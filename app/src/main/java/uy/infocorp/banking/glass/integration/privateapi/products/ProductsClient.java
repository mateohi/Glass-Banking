package uy.infocorp.banking.glass.integration.privateapi.products;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.offline.OfflineResourceUtils;

public class ProductsClient {

    private static final String X_AUTH_TOKEN_HEADER_NAME = "X-Auth-Token";

    private static ProductsClient instance;
    private RestExecutionBuilder builder;

    private ProductsClient() {
        builder = RestExecutionBuilder.get(PrivateUrls.GET_CONSOLIDATED_POSITION_URL);
    }

    public static ProductsClient instance() {
        if (instance == null) {
            instance = new ProductsClient();
        }
        return instance;
    }

    public List<Product> getConsolidatedPosition(String authToken) throws UnsupportedEncodingException {
        if (OfflineResourceUtils.offline()) {
            Product[] products = OfflineResourceUtils.jsonToObject(R.raw.products, Product[].class);
            return Arrays.asList(products);
        }

        Header tokenHeader = new BasicHeader(X_AUTH_TOKEN_HEADER_NAME, authToken);
        Product[] products = builder.appendHeader(tokenHeader).execute(Product[].class);

        return Arrays.asList(products);
    }



}
