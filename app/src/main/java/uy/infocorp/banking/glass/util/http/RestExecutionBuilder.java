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
import java.net.URI;

import uy.infocorp.banking.glass.exception.ConnectionException;
import uy.infocorp.banking.glass.exception.InvalidHttpVerbException;
import uy.infocorp.banking.glass.exception.ServerException;

public class RestExecutionBuilder {

    private static final String TAG = RestExecutionBuilder.class.getSimpleName();
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    private static final Gson GSON = new Gson();

    private HttpRequestBase request;
    private HttpClient httpClient;

    private RestExecutionBuilder(HttpRequestBase request) {
        this.request = request;
        this.httpClient = HttpUtils.defaultHttpClient();
    }

    public static RestExecutionBuilder get() {
        return new RestExecutionBuilder(new HttpGet());
    }

    public static RestExecutionBuilder get(String url) {
        return new RestExecutionBuilder(new HttpGet(url));
    }

    public static RestExecutionBuilder post() {
        return new RestExecutionBuilder(new HttpPost());
    }

    public static RestExecutionBuilder post(String url) {
        return new RestExecutionBuilder(new HttpPost(url));
    }

    public RestExecutionBuilder appendUrl(String url) {
        this.request.setURI(URI.create(url));
        return this;
    }

    public RestExecutionBuilder appendJsonBody(String json) throws UnsupportedEncodingException {
        StringEntity entity = new StringEntity(json);

        if (this.request instanceof HttpPost) {
            ((HttpPost) this.request).setEntity(entity);
        } else if (this.request instanceof HttpPut) {
            ((HttpPut) this.request).setEntity(entity);
        } else {
            throw new InvalidHttpVerbException("HTTP request can't have a body");
        }

        return this;
    }

    public RestExecutionBuilder appendObjectBody(Object body) throws UnsupportedEncodingException {
        return appendJsonBody(GSON.toJson(body));
    }

    public RestExecutionBuilder appendHeader(Header header) throws ExceptionInInitializerError {
        for (Header item: this.request.getAllHeaders()){
            if (item.getName().equals(header.getName())){
                this.request.setHeader(header);
                return this;
            }
        }
        //add the new header
        this.request.addHeader(header);
        return this;
    }

    public <T> T execute(Class<T> clazz) {
        this.request.setHeader(CONTENT_TYPE, APPLICATION_JSON);
        try {
            HttpResponse response = this.httpClient.execute(this.request);
            int status = response.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                return HttpUtils.typeFromResponse(response, clazz);
            } else {
                Log.e(TAG, "Server response: " + status);
                throw new ServerException(this.request.getURI().getHost(), response);
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            throw new ConnectionException(this.request.getURI().getHost());
        }
    }

    public <T> Pair executeAndGetHeaders(Class<T> clazz) {
        this.request.setHeader(CONTENT_TYPE, APPLICATION_JSON);
        try {
            HttpResponse response = this.httpClient.execute(this.request);
            int status = response.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                return HttpUtils.typeAndHeadersFromResponse(response, clazz);
            } else {
                Log.e(TAG, "Server response: " + status);
                throw new ServerException(this.request.getURI().getHost(), response);
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            throw new ConnectionException(this.request.getURI().getHost());
        }
    }
}
