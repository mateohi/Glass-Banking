package uy.infocorp.banking.glass.integration.privateapi.servicePayments;

import java.io.UnsupportedEncodingException;

import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;

public class ServicePaymentsClient {

    private static ServicePaymentsClient instance;
    private RestExecutionBuilder builder;

    private ServicePaymentsClient() {
        builder = RestExecutionBuilder.get();
    }

    public static ServicePaymentsClient instance() {
        if (instance == null) {
            instance = new ServicePaymentsClient();
        }
        return instance;
    }

    public void getServicePayments() throws UnsupportedEncodingException {
//        return this.builder.appendUrl(PrivateUrls.GET_SERVICE_PAYMENTS_URL).execute(Message.class);
    }

}
