package uy.infocorp.banking.glass.integration.publicapi.info;

import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import uy.infocorp.banking.glass.exception.ConnectionException;
import uy.infocorp.banking.glass.exception.ServerException;
import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PublicInfoDTO;
import uy.infocorp.banking.glass.util.http.HttpUtils;

public class PublicInfoClient {

    private static final String TAG = PublicInfoClient.class.getSimpleName();

    private static PublicInfoClient instance;
    private HttpClient httpClient;

    private PublicInfoClient() {
        this.httpClient = HttpUtils.defaultHttpClient();
    }

    public static PublicInfoClient instance() {
        if (instance == null) {
            instance = new PublicInfoClient();
        }
        return instance;
    }

    public PublicInfoDTO getPublicInfo() {
        HttpGet httpGet = new HttpGet(PublicUrls.GET_PUBLIC_INFO_URL);
        try {
            HttpResponse response = this.httpClient.execute(httpGet);
            int status = response.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                return HttpUtils.typeFromResponse(response, PublicInfoDTO.class);
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
