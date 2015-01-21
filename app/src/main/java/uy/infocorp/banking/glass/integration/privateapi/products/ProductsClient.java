package uy.infocorp.banking.glass.integration.privateapi.products;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.HttpUtils;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.Resources;

public class ProductsClient extends BaseClient {

    private static ProductsClient instance;
    private RestExecutionBuilder builder;
    private String authToken;

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
        this.authToken = authToken;
        return (List<Product>) this.execute();
    }

    @Override
    protected Object getOffline() {
        Product[] products = Resources.jsonToObject(R.raw.products, Product[].class);
        return Arrays.asList(products);
    }

    @Override
    protected Object getOnline() {
        Header tokenHeader = HttpUtils.buildTokenHeader(authToken);
        Product[] products = builder.appendHeader(tokenHeader).execute(Product[].class);

        return Arrays.asList(products);
    }
}
