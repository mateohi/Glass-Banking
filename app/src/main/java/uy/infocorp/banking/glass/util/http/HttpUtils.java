package uy.infocorp.banking.glass.util.http;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import org.apache.commons.lang3.tuple.Pair;
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

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

public class HttpUtils {

    private static final int DEFAULT_TIMEOUT = (int) TimeUnit.SECONDS.toMillis(300);
    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Product.class, new ProductHierarchyAdapter())
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

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
        T result = typeFromResponse(response, clazz);
        List<Header> headers = Arrays.asList(response.getAllHeaders());
        return Pair.of(result, headers);
    }

    public static <T> T typeFromStringData(String data, Class<T> clazz) {
            return GSON.fromJson(data, clazz);
    }
}
