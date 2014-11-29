package uy.infocorp.banking.glass.integration.publicapi.image;

import android.graphics.Bitmap;

import org.apache.commons.lang3.ArrayUtils;

import java.util.NoSuchElementException;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.image.dto.ImageDTO;
import uy.infocorp.banking.glass.util.graphics.BitmapUtils;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.ResourceUtils;

public class ImageDownloadClient extends BaseClient{

    private static ImageDownloadClient instance;
    private RestExecutionBuilder builder;
    private int imageId;

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
        this.imageId = imageId;
        return (Bitmap)this.execute();
    }

    @Override
    public Object getOffline() {
        ImageDTO image = ResourceUtils.jsonToObject(R.raw.image_1, ImageDTO.class);
        return BitmapUtils.base64ToBitmap(image.getImagePicture());
    }

    @Override
    public Object getOnline() {
        String uri = String.format(PublicUrls.GET_IMAGE_URL, this.imageId);
        ImageDTO[] images = this.builder.appendUrl(uri).execute(ImageDTO[].class);

        if (ArrayUtils.isEmpty(images)) {
            throw new NoSuchElementException("No image with id " + this.imageId);
        }

        String imageBase64 = images[0].getImagePicture();

        return BitmapUtils.base64ToBitmap(imageBase64);
    }
}

