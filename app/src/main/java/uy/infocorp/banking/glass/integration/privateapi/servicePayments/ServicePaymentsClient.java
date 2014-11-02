package uy.infocorp.banking.glass.integration.privateapi.servicePayments;

import java.io.UnsupportedEncodingException;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.util.http.RestClient;

public class ServicePaymentsClient {

    private static ServicePaymentsClient instance;
    private RestClient client;

    private ServicePaymentsClient() {
        client = new RestClient();
    }

    public static ServicePaymentsClient instance() {
        if (instance == null) {
            instance = new ServicePaymentsClient();
        }
        return instance;
    }

    public void getServicePayments() throws UnsupportedEncodingException {
//        return this.client.get(PrivateUrls.GET_SERVICE_PAYMENTS_URL, Message.class);
    }

}
