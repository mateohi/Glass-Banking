package uy.infocorp.banking.glass.integration.privateapi.servicePayments;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.servicePayments.ServicePayment;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.ResourceUtils;

public class ServicePaymentsClient extends BaseClient {

    private static ServicePaymentsClient instance;
    private RestExecutionBuilder builder;
    private String authToken;

    private ServicePaymentsClient() {
        builder = RestExecutionBuilder.get(PrivateUrls.GET_SERVICE_PAYMENTS_URL);
    }

    public static ServicePaymentsClient instance() {
        if (instance == null) {
            instance = new ServicePaymentsClient();
        }
        return instance;
    }

    public List<ServicePayment> getServicePayments(String authToken) throws UnsupportedEncodingException {
        this.authToken = authToken;
        return (List<ServicePayment>) this.execute();
    }

    @Override
    public Object getOffline() {
        return ResourceUtils.jsonToObject(R.raw.service_payments, ServicePayment.class);
    }

    @Override
    public Object getOnline() {
        String xAuthTokenHeaderName = ResourceUtils.getString(R.string.x_auth_header);
        Header tokenHeader = new BasicHeader(xAuthTokenHeaderName, this.authToken);
        ServicePayment[] servicePaymentList = builder.appendHeader(tokenHeader).execute(ServicePayment[].class);
        return Arrays.asList(servicePaymentList);
    }
}
