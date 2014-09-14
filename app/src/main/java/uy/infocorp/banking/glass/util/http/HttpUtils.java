package uy.infocorp.banking.glass.util.http;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HttpUtils {

    private static final int DEFAULT_TIMEOUT = (int) TimeUnit.SECONDS.toMillis(20);
    private static final Gson GSON = new Gson();

    public static HttpClient defaultHttpClient() {
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, DEFAULT_TIMEOUT);

        return new DefaultHttpClient(httpParams);
    }

    public static <T> T typeFromResponse(HttpResponse response, Class<T> clazz) throws IOException {
        String data = EntityUtils.toString(response.getEntity());
        return GSON.fromJson(data, clazz);
    }
}
