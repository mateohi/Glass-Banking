package uy.infocorp.banking.glass.integration.publicapi.image;

import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.image.dto.ImageDTO;
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

    public ImageDTO getImage(int imageId) {
        String uri = String.format(PublicUrls.GET_IMAGE_URL, imageId);
        ImageDTO[] images = this.client.get(uri, ImageDTO[].class);

        return images[0];
    }

}

