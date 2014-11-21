package uy.infocorp.banking.glass.integration.publicapi.image;

import android.graphics.Bitmap;

import uy.infocorp.banking.glass.util.graphics.BitmapUtils;

public class OfflineImageDownloadClient {

    private static final String OFFLINE_BASE64_IMAGE = "";

    public static Bitmap getImage() {
        return BitmapUtils.base64ToBitmap(OFFLINE_BASE64_IMAGE);
    }
}
