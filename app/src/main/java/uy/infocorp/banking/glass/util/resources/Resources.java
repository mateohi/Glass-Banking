package uy.infocorp.banking.glass.util.resources;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.exception.ResourceParsingException;
import uy.infocorp.banking.glass.util.BankingApplication;
import uy.infocorp.banking.glass.util.http.HttpUtils;

public class Resources {

    private static final String TAG = Resources.class.getSimpleName();
    private static Context context = BankingApplication.getContext();

    public static String getString(int id) {
        return context.getResources().getString(id);
    }

    public static int getInteger(int id) {
        return context.getResources().getInteger(id);
    }

    public static boolean getBoolean(int id) {
        return context.getResources().getBoolean(id);
    }

    public static boolean offline() {
        return getBoolean(R.bool.offline_mode);
    }

    public static <T> T jsonToObject(int resourceId, Class<T> clazz) {
        String json = readResource(context, resourceId);
        return HttpUtils.typeFromStringData(json, clazz);
    }

    private static String readResource(Context context, int resourceId) {
        InputStream is = context.getResources().openRawResource(resourceId);
        StringBuffer buffer = new StringBuffer();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                buffer.append('\n');
            }
        } catch (IOException e) {
            Log.e(TAG, "Could not read resource", e);
            throw new ResourceParsingException(e.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    Log.e(TAG, "Could not close resource stream", e);
                }
            }
        }

        return buffer.toString();
    }

}
