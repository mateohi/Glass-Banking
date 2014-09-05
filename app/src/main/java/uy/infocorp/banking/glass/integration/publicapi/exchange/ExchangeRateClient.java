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

    private String test() {
        return "[{\"sourceCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"destinationCurrency\":{\"currencyId\":\"32\",\"currencyAlpha3Code\":\"ARS\",\"currencyDescription\":\"Argentine peso\",\"currencySymbol\":\"$\"},\"buyRate\":4.49,\"sellRate\":5.26,\"official\":5.09},{\"sourceCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"destinationCurrency\":{\"currencyId\":\"840\",\"currencyAlpha3Code\":\"USD\",\"currencyDescription\":\"United States dollar\",\"currencySymbol\":\"US$\"},\"buyRate\":19.15,\"sellRate\":20.25,\"official\":19.95},{\"sourceCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"destinationCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"buyRate\":1.00,\"sellRate\":1.00,\"official\":1.00},{\"sourceCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"destinationCurrency\":{\"currencyId\":\"978\",\"currencyAlpha3Code\":\"EUR\",\"currencyDescription\":\"Euro\",\"currencySymbol\":\"€\"},\"buyRate\":25.10,\"sellRate\":33.33,\"official\":31.89},{\"sourceCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"destinationCurrency\":{\"currencyId\":\"986\",\"currencyAlpha3Code\":\"BRL\",\"currencyDescription\":\"Brazilian real\",\"currencySymbol\":\"R$\"},\"buyRate\":10.49,\"sellRate\":11.00,\"official\":10.50}]";
    }

}

