package uy.infocorp.banking.glass.controller.benefit;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.LiveCard.PublishMode;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.model.benefit.Benefit;

public class BenefitsService extends Service {

    private static final String TAG = BenefitsService.class.getSimpleName();

    private final BenefitsBinder binder = new BenefitsBinder();

    private OrientationManager orientationManager;
    private TextToSpeech speech;

    private LiveCard liveCard;
    private BenefitsCompassRenderer benefitsCompassRenderer;

    @Override
    public void onCreate() {
        super.onCreate();

        this.speech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                Log.i(TAG, "Text to speech initialized ...");
            }
        });

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        LocationManager locationManager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        orientationManager = new OrientationManager(sensorManager, locationManager);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (liveCard == null) {
            liveCard = new LiveCard(this, TAG);
            benefitsCompassRenderer = new BenefitsCompassRenderer(this, orientationManager);

            liveCard.setDirectRenderingEnabled(true).getSurfaceHolder().addCallback(benefitsCompassRenderer);

            // Display the options menu when the live card is tapped.
            Intent menuIntent = new Intent(this, BenefitsMenuActivity.class);
            menuIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            liveCard.setAction(PendingIntent.getActivity(this, 0, menuIntent, 0));
            liveCard.attach(this);
            liveCard.publish(PublishMode.REVEAL);
        } else {
            liveCard.navigate();
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (liveCard != null && liveCard.isPublished()) {
            liveCard.unpublish();
            liveCard = null;
        }

        this.speech.shutdown();

        this.speech = null;
        this.orientationManager = null;

        super.onDestroy();
    }

    public void stopService() {
        this.stopSelf();
    }

    public class BenefitsBinder extends Binder {

        public void readBenefitDescription() {
            Benefit benefit = benefitsCompassRenderer.getFrontBenefit();
            String spokenDescription = getResources().getString(R.string.benefit_to_speech,
                    benefit.getDescription(), benefit.getName());

            speech.speak(spokenDescription, TextToSpeech.QUEUE_FLUSH, null);
        }

        public void getDirections() {
            Benefit benefit = benefitsCompassRenderer.getFrontBenefit();
            String uri = getResources().getString(R.string.maps_intent_uri, benefit.getLatitude(),
                    benefit.getLongitude(), benefit.getName());

            Intent mapIntent = new Intent(Intent.ACTION_VIEW);
            mapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mapIntent.setData(Uri.parse(uri));

            startActivity(mapIntent);
        }
    }
}
