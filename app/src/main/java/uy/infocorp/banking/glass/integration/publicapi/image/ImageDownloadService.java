package uy.infocorp.banking.glass.integration.publicapi.image;

import android.graphics.Bitmap;

import uy.infocorp.banking.glass.integration.publicapi.image.dto.ImageDTO;
import uy.infocorp.banking.glass.util.graphics.BitmapUtils;

public class ImageDownloadService {

    public static Bitmap getImage(int imageId) {
        ImageDTO imageDTO = ImageDownloadClient.instance().getImage(imageId);
        String imageBase64 = imageDTO.getImagePicture();

        return BitmapUtils.base64ToBitmap(imageBase64);
    }

}

