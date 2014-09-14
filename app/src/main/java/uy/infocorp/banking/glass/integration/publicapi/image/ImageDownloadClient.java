package uy.infocorp.banking.glass.integration.publicapi.image;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import uy.infocorp.banking.glass.exception.ConnectionException;
import uy.infocorp.banking.glass.exception.ServerException;
import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.image.dto.ImageDTO;
import uy.infocorp.banking.glass.util.http.HttpUtils;

public class ImageDownloadClient {

    private static final String TAG = ImageDownloadClient.class.getSimpleName();

    private static ImageDownloadClient instance;
    private HttpClient httpClient;

    private ImageDownloadClient() {
        this.httpClient = HttpUtils.defaultHttpClient();
    }

    public static ImageDownloadClient instance() {
        if (instance == null) {
            instance = new ImageDownloadClient();
        }
        return instance;
    }

    public ImageDTO getImage(int imageId) {
        HttpGet httpGet = new HttpGet(String.format(PublicUrls.GET_IMAGE_URL, imageId));
        try {
            HttpResponse response = this.httpClient.execute(httpGet);
            int status = response.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                ImageDTO[] images = HttpUtils.typeFromResponse(response, ImageDTO[].class);
                return images[0];
            }
            else {
                Log.e(TAG, "Server response: " + status);
                throw new ServerException(httpGet.getURI().getHost(), response);
            }
        }
        catch (IOException e) {
            Log.e(TAG, e.getMessage());
            throw new ConnectionException(httpGet.getURI().getHost());
        }
    }

}

