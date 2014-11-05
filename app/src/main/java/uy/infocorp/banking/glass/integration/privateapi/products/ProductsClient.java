package uy.infocorp.banking.glass.integration.privateapi.products;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.util.http.RestClientBuilder;

/**
 * Created by german on 15/10/2014.
 */
public class ProductsClient {

    private static final String TAG = ProductsClient.class.getSimpleName();
    private static final String X_AUTH_TOKEN_HEADER_NAME = "X-Auth-Token";

    private static ProductsClient  instance;
    private RestClientBuilder client;

    private ProductsClient () {
        client = new RestClientBuilder();
    }

    public static ProductsClient instance() {
        if (instance == null) {
            instance = new ProductsClient ();
        }
        return instance;
    }

    public List<Product> getConsolidatedPosition(String authToken) throws UnsupportedEncodingException {
        RestClientBuilder restClient = new RestClientBuilder();
        Header tokenHeader = new BasicHeader(X_AUTH_TOKEN_HEADER_NAME, authToken);
        //initialize url and add x_auth_token header
        restClient.get(PrivateUrls.GET_CONSOLIDATED_POSITION_URL).appendHeader(tokenHeader);
        //do get
        Product[] productList = restClient.execute(Product[].class);
        return Arrays.asList(productList);
    }

}
