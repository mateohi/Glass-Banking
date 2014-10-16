package uy.infocorp.banking.glass.integration.privateapi.products;

import java.io.UnsupportedEncodingException;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityQuestionsAnswers;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.util.http.RestClient;

/**
 * Created by german on 15/10/2014.
 */
public class ProductsClient {
    private static ProductsClient  instance;
    private RestClient client;

    private ProductsClient () {
        client = new RestClient();
    }

    public static ProductsClient instance() {
        if (instance == null) {
            instance = new ProductsClient ();
        }
        return instance;
    }

    public Product getConsolidatedPosition() throws UnsupportedEncodingException {
        return this.client.get(PrivateUrls.GET_CONSOLIDATED_POSITION_URL, Product.class);
    }

    public SecurityQuestionsAnswers validateSecurityDevice(SecurityQuestionsAnswers securityQuestionsAnswers) throws UnsupportedEncodingException {
        return this.client.post(PrivateUrls.POST_VALIDATE_SECURITY_DEVICE_URL, SecurityQuestionsAnswers.class, securityQuestionsAnswers);
    }

}
