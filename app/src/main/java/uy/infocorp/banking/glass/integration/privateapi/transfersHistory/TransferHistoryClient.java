package uy.infocorp.banking.glass.integration.privateapi.transfersHistory;

/**
 * Created by german on 16/10/2014.
 */
import java.io.UnsupportedEncodingException;
import java.util.Date;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.util.http.RestClient;

public class TransferHistoryClient {
    private static TransferHistoryClient instance;
    private RestClient client;

    private TransferHistoryClient () {
        client = new RestClient();
    }

    public static TransferHistoryClient instance() {
        if (instance == null) {
            instance = new TransferHistoryClient();
        }
        return instance;
    }

    public void getTransfersHistoryBetween(Date from, Date to) throws UnsupportedEncodingException {
//        return this.client.get(PrivateUrls.GET_TRANSFERS_HISTORY_URL, Message.class);
    }

}
