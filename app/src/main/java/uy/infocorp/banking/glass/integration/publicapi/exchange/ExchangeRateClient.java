package uy.infocorp.banking.glass.integration.publicapi.exchange;

import android.util.Log;

import com.google.gson.Gson;

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
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;

public class ExchangeRateClient {

    private static final String TAG = ExchangeRateClient.class.getSimpleName();

    private static ExchangeRateClient instance;
    private HttpClient httpClient;
    private Gson gson;

    private ExchangeRateClient() {
        this.httpClient = new DefaultHttpClient();
        this.gson = new Gson();
    }

    public static ExchangeRateClient instance() {
        if (instance == null) {
            instance = new ExchangeRateClient();
        }
        return instance;
    }

    public ExchangeRateDTO[] getExchangeRates() {
        HttpGet httpGet = new HttpGet(PublicUrls.GET_EXCHANGE_RATES_URL);
        try {
            HttpResponse response = this.httpClient.execute(httpGet);
            int status = response.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                String data = EntityUtils.toString(response.getEntity());
                ExchangeRateDTO[] rates = this.gson.fromJson(data, ExchangeRateDTO[].class);
                return rates;
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

