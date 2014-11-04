package uy.infocorp.banking.glass.util.http;

import android.util.Pair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HttpUtils {

    private static final int DEFAULT_TIMEOUT = (int) TimeUnit.SECONDS.toMillis(300);
    private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    public static HttpClient defaultHttpClient() {
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, DEFAULT_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpParams, DEFAULT_TIMEOUT);

        return new DefaultHttpClient(httpParams);
    }

    public static <T> T typeFromResponse(HttpResponse response, Class<T> clazz) throws IOException {
        String data = EntityUtils.toString(response.getEntity());
        return GSON.fromJson(data, clazz);
    }

    public static <T> Pair<T, List<Header>> typeAndHeadersFromResponse(HttpResponse response, Class<T> clazz) throws IOException {
        String data = EntityUtils.toString(response.getEntity());
        T result = GSON.fromJson(data, clazz);
        List<Header> headers = Arrays.asList(response.getAllHeaders());
        return new Pair<T, List<Header>>(result, headers);
    }
}
