package uy.infocorp.banking.glass.domain.ocr;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BitmapModifier {


    public static Bitmap byFour(Bitmap original) {
        int oldWidth = original.getWidth();
        int oldHeight = original.getHeight();

        Bitmap result = Bitmap.createBitmap(oldWidth * 2, oldHeight * 2, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();

        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(original, 0, 0, paint);
        canvas.drawBitmap(original, 0, oldHeight, paint);
        canvas.drawBitmap(original, oldWidth, 0, paint);
        canvas.drawBitmap(original, oldWidth, oldHeight, paint);

        return result;
    }

    public static Bitmap addBorder(Bitmap bitmap, int borderSize) {
        int newWidth = bitmap.getWidth() + borderSize * 2;
        int newHeight = bitmap.getHeight() + borderSize * 2;

        Bitmap result = Bitmap.createBitmap(newWidth, newHeight, bitmap.getConfig());

        Canvas canvas = new Canvas(result);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap, borderSize, borderSize, new Paint(Paint.FILTER_BITMAP_FLAG));

        return result;
    }
}
