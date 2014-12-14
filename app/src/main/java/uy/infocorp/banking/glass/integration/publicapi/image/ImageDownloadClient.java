package uy.infocorp.banking.glass.integration.publicapi.image;

import android.graphics.Bitmap;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.image.dto.ImageDTO;
import uy.infocorp.banking.glass.util.graphics.BitmapUtils;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.Resources;

public class ImageDownloadClient extends BaseClient {

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
        return (Bitmap) this.execute();
    }

    @Override
    protected Object getOffline() {
        ImageDTO image = Resources.jsonToObject(randomImage(), ImageDTO.class);
        return BitmapUtils.base64ToBitmap(image.getImagePicture());
    }

    @Override
    protected Object getOnline() {
        String uri = String.format(PublicUrls.GET_IMAGE_URL, this.imageId);
        ImageDTO[] images = this.builder.appendUrl(uri).execute(ImageDTO[].class);

        if (ArrayUtils.isEmpty(images)) {
            throw new NoSuchElementException("No image with id " + this.imageId);
        }

        String imageBase64 = images[0].getImagePicture();

        return BitmapUtils.base64ToBitmap(imageBase64);
    }

    private int randomImage() {
        List<Integer> images = Arrays.asList(R.raw.image_1, R.raw.image_2, /*R.raw.image_3,crucero*/
                /*R.raw.image_4, es una de masajes*/ R.raw.image_5);
        int random = new Random().nextInt(images.size());

        return images.get(random);
    }
}

