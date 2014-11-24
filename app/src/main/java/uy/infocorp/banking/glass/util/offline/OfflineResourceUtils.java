package uy.infocorp.banking.glass.util.offline;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.exception.ResourceParsingException;
import uy.infocorp.banking.glass.util.http.HttpUtils;

public class OfflineResourceUtils {

    private static final String TAG = OfflineResourceUtils.class.getSimpleName();

    public static <T> T jsonResourceToObject(Context context, int resourceId, Class<T> clazz) {
        String json = readLandmarksResource(context, resourceId);
        return HttpUtils.typeFromStringData(json, clazz);
    }

    private static String readLandmarksResource(Context context, int resourceId) {
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
