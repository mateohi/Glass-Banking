package uy.infocorp.banking.glass.icbankingglass.util.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class BitmapUtils {

    public static Bitmap base64ToBitmap(String imageBase64) {
        byte[] imageBytes = Base64.decode(imageBase64, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }
}
