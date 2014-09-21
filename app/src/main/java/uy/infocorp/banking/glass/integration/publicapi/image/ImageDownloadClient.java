package uy.infocorp.banking.glass.integration.publicapi.image;

import android.graphics.Bitmap;

import java.util.NoSuchElementException;

import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.image.dto.ImageDTO;
import uy.infocorp.banking.glass.util.graphics.BitmapUtils;
import uy.infocorp.banking.glass.util.http.RestClient;

public class ImageDownloadClient {

    private static ImageDownloadClient instance;
    private RestClient client;

    private ImageDownloadClient() {
        this.client = new RestClient();
    }

    public static ImageDownloadClient instance() {
        if (instance == null) {
            instance = new ImageDownloadClient();
        }
        return instance;
    }

    public Bitmap getImage(int imageId) {
        String uri = String.format(PublicUrls.GET_IMAGE_URL, imageId);
        ImageDTO[] images = this.client.get(uri, ImageDTO[].class);

        if (images == null || images.length == 0) {
            throw new NoSuchElementException("No image with id " + imageId);
        }

        String imageBase64 = images[0].getImagePicture();

        return BitmapUtils.base64ToBitmap(imageBase64);
    }

}

