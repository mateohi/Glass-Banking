package uy.infocorp.banking.glass.integration.publicapi.image;

import android.graphics.Bitmap;

import org.apache.commons.lang3.ArrayUtils;

import java.util.NoSuchElementException;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.image.dto.ImageDTO;
import uy.infocorp.banking.glass.util.graphics.BitmapUtils;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.offline.OfflineResourceUtils;

public class ImageDownloadClient {

    private static ImageDownloadClient instance;
    private RestExecutionBuilder builder;

    private ImageDownloadClient() {
        this.builder = RestExecutionBuilder.get();
    }

    public static ImageDownloadClient instance() {
        if (instance == null) {
            instance = new ImageDownloadClient();
        }
        return instance;
    }

    public Bitmap getImage(int imageId) {
        if (OfflineResourceUtils.offline()) {
            ImageDTO image = OfflineResourceUtils.jsonToObject(R.raw.image_1, ImageDTO.class);
            return BitmapUtils.base64ToBitmap(image.getImagePicture());
        }

        String uri = String.format(PublicUrls.GET_IMAGE_URL, imageId);
        ImageDTO[] images = this.builder.appendUrl(uri).execute(ImageDTO[].class);

        if (ArrayUtils.isEmpty(images)) {
            throw new NoSuchElementException("No image with id " + imageId);
        }

        String imageBase64 = images[0].getImagePicture();

        return BitmapUtils.base64ToBitmap(imageBase64);
    }

}

