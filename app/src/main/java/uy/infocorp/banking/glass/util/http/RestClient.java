package uy.infocorp.banking.glass.util.http;

import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import uy.infocorp.banking.glass.exception.ConnectionException;
import uy.infocorp.banking.glass.exception.ServerException;

public class RestClient {

    private static final String TAG = RestClient.class.getSimpleName();
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    private HttpClient httpClient;
    private Gson gson;

    public RestClient() {
        this.httpClient = HttpUtils.defaultHttpClient();
        this.gson = new Gson();
    }

    public <T> T delete(String url, Class<T> clazz) {
        HttpDelete delete = new HttpDelete(url);
        return execute(clazz, delete);
    }

    public <T> T get(String url, Class<T> clazz) {
        HttpGet get = new HttpGet(url);
        return execute(clazz, get);
    }

    public <T> T post(String url, Class<T> clazz) {
        HttpPost post = new HttpPost(url);
        return execute(clazz, post);
    }

    public <T> T post(String url, Class<T> clazz, String body) throws UnsupportedEncodingException {
        StringEntity entity = new StringEntity(body);

        HttpPost post = new HttpPost(url);
        post.setEntity(entity);

        return execute(clazz, post);
    }

    public <T> T post(String url, Class<T> clazz, Object body) throws UnsupportedEncodingException {
        String jsonBody = gson.toJson(body);
        StringEntity entity = new StringEntity(jsonBody);

        HttpPost post = new HttpPost(url);
        post.setEntity(entity);

        return execute(clazz, post);
    }

    public <T> T put(String url, Class<T> clazz) {
        HttpPut put = new HttpPut(url);
        return execute(clazz, put);
    }

    public <T> T put(String url, Class<T> clazz, String body) throws UnsupportedEncodingException {
        StringEntity entity = new StringEntity(body);

        HttpPut put = new HttpPut(url);
        put.setEntity(entity);

        return execute(clazz, put);
    }

    public <T> T put(String url, Class<T> clazz, Object body) throws UnsupportedEncodingException {
        String jsonBody = gson.toJson(body);
        StringEntity entity = new StringEntity(jsonBody);

        HttpPut put = new HttpPut(url);
        put.setEntity(entity);

        return execute(clazz, put);
    }

    private <T> T execute(Class<T> clazz, HttpRequestBase request) {
        request.addHeader(CONTENT_TYPE, APPLICATION_JSON);
        try {
            HttpResponse response = this.httpClient.execute(request);
            int status = response.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                return HttpUtils.typeFromResponse(response, clazz);
            }
            else {
                Log.e(TAG, "Server response: " + status);
                throw new ServerException(request.getURI().getHost(), response);
            }
        }
        catch (IOException e) {
            Log.e(TAG, e.getMessage());
            throw new ConnectionException(request.getURI().getHost());
        }
    }
}
