package uy.infocorp.banking.glass.integration.privateapi.products;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.util.http.RestClient;

/**
 * Created by german on 15/10/2014.
 */
public class ProductsClient {

    private static final String TAG = ProductsClient.class.getSimpleName();
    private static final String X_AUTH_TOKEN_HEADER_NAME = "X-Auth-Token";

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

    public List<Product> getConsolidatedPosition(String authToken) throws UnsupportedEncodingException {
        //add x_auth_token header
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader(X_AUTH_TOKEN_HEADER_NAME, authToken));
        //do get
        Product[] productList = this.client.get(PrivateUrls.GET_CONSOLIDATED_POSITION_URL, Product[].class, headers);
        return Arrays.asList(productList);
    }

}
