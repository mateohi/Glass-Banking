package uy.infocorp.banking.glass.util.http;

import android.util.Log;
import com.google.gson.Gson;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.Header;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.exception.ConnectionException;
import uy.infocorp.banking.glass.exception.ServerException;

public class RestClientBuilder {

    private static final String TAG = RestClientBuilder.class.getSimpleName();
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    private HttpRequestBase requestBase;
    private HttpClient httpClient;
    private Gson gson;

    public RestClientBuilder() {
        this.httpClient = HttpUtils.defaultHttpClient();
        this.gson = new Gson();
    }

    public RestClientBuilder delete(String url) {
        this.requestBase = new HttpDelete(url);
        return this;
    }

    public RestClientBuilder get(String url) {
        this.requestBase = new HttpGet(url);
        return this;
    }

    public RestClientBuilder appendHeader(Header header) throws ExceptionInInitializerError {
        if(this.requestBase !=null){
            this.requestBase.addHeader(header);
        }else{
            throw new ExceptionInInitializerError("The RestClientBuilder Was not instantiated yet");
        }
        return this;
    }

    public RestClientBuilder post(String url) {
        HttpPost post = new HttpPost(url);
        this.requestBase = post;
        return this;
    }

    public RestClientBuilder post(String url, String body) throws UnsupportedEncodingException {
        StringEntity entity = new StringEntity(body);

        HttpPost post = new HttpPost(url);
        post.setEntity(entity);
        this.requestBase = post;
        return this;
    }

    public RestClientBuilder post(String url, Object body) throws UnsupportedEncodingException {
        String jsonBody = gson.toJson(body);
        StringEntity entity = new StringEntity(jsonBody);

        HttpPost post = new HttpPost(url);
        post.setEntity(entity);
        this.requestBase = post;
        return this;
    }


    public RestClientBuilder put(String url) {
        this.requestBase = new HttpPut(url);
        return this;
    }

    public RestClientBuilder put(String url, String body) throws UnsupportedEncodingException {
        StringEntity entity = new StringEntity(body);

        HttpPut put = new HttpPut(url);
        put.setEntity(entity);
        this.requestBase = put;
        return this;
    }

    public RestClientBuilder put(String url, Object body) throws UnsupportedEncodingException {
        String jsonBody = gson.toJson(body);
        StringEntity entity = new StringEntity(jsonBody);

        HttpPut put = new HttpPut(url);
        put.setEntity(entity);
        this.requestBase = put;
        return this;
    }

    public <T> T execute(Class<T> clazz) {
        this.requestBase.addHeader(CONTENT_TYPE, APPLICATION_JSON);
        try {
            HttpResponse response = this.httpClient.execute(this.requestBase);
            int status = response.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                return HttpUtils.typeFromResponse(response, clazz);
            }
            else {
                Log.e(TAG, "Server response: " + status);
                throw new ServerException(this.requestBase.getURI().getHost(), response);
            }
        }
        catch (IOException e) {
            Log.e(TAG, e.getMessage());
            throw new ConnectionException(this.requestBase.getURI().getHost());
        }
    }

    public <T> Pair executeAndGetHeaders(Class<T> clazz) {
        this.requestBase.addHeader(CONTENT_TYPE, APPLICATION_JSON);
        try {
            HttpResponse response = this.httpClient.execute(this.requestBase);
            int status = response.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                return HttpUtils.typeAndHeadersFromResponse(response, clazz);
            }
            else {
                Log.e(TAG, "Server response: " + status);
                throw new ServerException(this.requestBase.getURI().getHost(), response);
            }
        }
        catch (IOException e) {
            Log.e(TAG, e.getMessage());
            throw new ConnectionException(this.requestBase.getURI().getHost());
        }
    }
}
