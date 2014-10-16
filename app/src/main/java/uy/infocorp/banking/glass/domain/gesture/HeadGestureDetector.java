package uy.infocorp.banking.glass.domain.gesture;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.google.common.collect.EvictingQueue;
import com.google.common.collect.Queues;

import java.util.Queue;

/*
 *      Calculo del Nod:
 * ------------------------------------------------------------------------------------------------
 * Calculando que se tardan entre 1 y 2 segundos realizar un nod, se guardan los 50 valores del
 * angulo correspondiente cada 50 milisegundos. Esto es, se guardan los intervalos cada 50
 * milisegundos de los ultimos 2,5 segundos.
 *
 * A partir de esto, se analiza que se tengan dos picos "high" y "low" entre los valores, lo que
 * representaria dos subidas y bajadas de cabeza.
 *------------------------------------------------------------------------------------------------
 *
 *      Calculo del headshake:
 * ------------------------------------------------------------------------------------------------
 * Explicacion
 * ------------------------------------------------------------------------------------------------
 *
 */

public class HeadGestureDetector {

    private static final String TAG = HeadGestureDetector.class.getSimpleName();

    private static final int ARM_DISPLACEMENT_DEGREES = 6;
    private static final int ANGLES_QUEUE_SIZE = 50;

    private Context context;
    private HeadGestureListener headGestureListener;

    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;

    private Queue<Float> nodAngles = Queues.synchronizedQueue(EvictingQueue.<Float>create(ANGLES_QUEUE_SIZE));
    private Queue<Float> headShakeAngles = Queues.synchronizedQueue(EvictingQueue.<Float>create(ANGLES_QUEUE_SIZE));

    private Thread checkThread;
    private boolean check;

    private float nodAngle;
    private float headShakeAngle;

    public HeadGestureDetector(Context context, HeadGestureListener headGestureListener) {
        this.context = context;
        this.headGestureListener = headGestureListener;

        this.sensorEventListener = createSensorEventListener();
        registerSensors();

        createCheckThread();
    }

    private void createCheckThread() {
        this.checkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (check) {
                    try {
                        Thread.sleep(50);
                        nodAngles.add(nodAngle);
                        headShakeAngles.add(headShakeAngle);
                        checkIfNodOrHeadShake();
                    }
                    catch (InterruptedException e) {
                        // Too bad
                    }
                }
            }
        });
    }

    public void stopListening() {
        if (this.sensorEventListener != null) {
            this.sensorManager.unregisterListener(this.sensorEventListener);
        }

        this.check = false;
        emptyNodAnglesQueue();
        emptyHeadShakeAnglesQueue();
    }

    public void startListening() {
        registerSensors();

        this.check = true;
        if (!this.checkThread.isAlive()) {
            this.checkThread.start();
        }
    }

    private SensorEventListener createSensorEventListener() {
        SensorEventListener sensorEventListener = new SensorEventListener() {

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }

            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
                    calculateNewAngles(event);
                }
            }
        };
        return sensorEventListener;
    }

    private void registerSensors() {
        this.sensorManager = (SensorManager) this.context.getSystemService(Context.SENSOR_SERVICE);
        this.sensorManager.registerListener(this.sensorEventListener,
                this.sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),
                SensorManager.SENSOR_DELAY_NORMAL);
        this.sensorManager.registerListener(this.sensorEventListener,
                this.sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
                SensorManager.SENSOR_DELAY_UI);
    }

    private void calculateNewAngles(SensorEvent event) {
        float[] rotationMatrix = new float[16];
        float[] orientation = new float[9];

        SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values);
        SensorManager.remapCoordinateSystem(rotationMatrix, SensorManager.AXIS_X,
                SensorManager.AXIS_Z, rotationMatrix);
        SensorManager.getOrientation(rotationMatrix, orientation);

        float magneticHeading = (float) Math.toDegrees(orientation[0]);
        this.headShakeAngle = mod(magneticHeading, 360.0f) - ARM_DISPLACEMENT_DEGREES;

        this.nodAngle = (float) Math.toDegrees(orientation[1]);
    }

    private void checkIfNodOrHeadShake() {
        Float[] nodAnglesArray = this.nodAngles.toArray(new Float[this.nodAngles.size()]);
        Float[] headShakeAnglesArray = this.headShakeAngles.toArray(new Float[this.headShakeAngles.size()]);

        boolean isNod = HeadGestureUtils.isNod(nodAnglesArray);
        boolean isHeadShake = HeadGestureUtils.isHeadShake(headShakeAnglesArray);

        if (isNod && !isHeadShake) {
            emptyNodAnglesQueue();
            this.headGestureListener.onNod();
        }

        if (!isNod && isHeadShake) {
            emptyHeadShakeAnglesQueue();
            this.headGestureListener.onHeadShake();
        }
    }

    private void emptyNodAnglesQueue() {
        synchronized (this.nodAngles) {
            while (!this.nodAngles.isEmpty()) {
                this.nodAngles.poll();
            }
        }
    }

    private void emptyHeadShakeAnglesQueue() {
        synchronized (this.headShakeAngles) {
            while (!this.headShakeAngles.isEmpty()) {
                this.headShakeAngles.poll();
            }
        }
    }

    public static float mod(float a, float b) {
        return (a % b + b) % b;
    }
}
