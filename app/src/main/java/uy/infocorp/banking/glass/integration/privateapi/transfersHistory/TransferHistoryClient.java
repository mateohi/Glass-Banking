package uy.infocorp.banking.glass.integration.privateapi.transfersHistory;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.ProductType;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.integration.privateapi.transfersHistory.dto.TransferHistoryResponseDTO;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.Resources;

public class TransferHistoryClient extends BaseClient {

    private static final int MAX_TRANSFERS_TO_SHOW = Resources.getInteger(R.integer.max_atms_to_show);

    private static TransferHistoryClient instance;
    private RestExecutionBuilder builder;
    private String authToken;
    private String productBankIdentifier;
    private ProductType productType;

    private TransferHistoryClient() {
        builder = RestExecutionBuilder.get();
    }

    public static TransferHistoryClient instance() {
        if (instance == null) {
            instance = new TransferHistoryClient();
        }
        return instance;
    }

    public List<Transfer> getLastTransfers(String authToken, ProductType productType,
                                           String productBankIdentifier) throws Exception {
        this.authToken = authToken;
        this.productType = productType;
        this.productBankIdentifier = productBankIdentifier;
        return (List<Transfer>) this.execute();
    }


    @Override
    protected Object getOffline() {
        Transfer[] transfers = Resources.jsonToObject(R.raw.transfers,
                Transfer[].class);
        return TransferHistoryUtils.getCorrectedTransfers(transfers);
    }

    @Override
    protected Object getOnline() {
        String xAuthTokenHeaderName = Resources.getString(R.string.x_auth_header);
        Header tokenHeader = new BasicHeader(xAuthTokenHeaderName, this.authToken);
        String formattedUrl = TransferHistoryUtils.buildFormattedUrl();
        TransferHistoryResponseDTO transferResponse = this.builder
                .appendUrl(formattedUrl)
                .appendHeader(tokenHeader)
                .execute(TransferHistoryResponseDTO.class);

        Transfer[] transfers = transferResponse.getItems();

        return TransferHistoryUtils.getCorrectedTransfers(transfers);
    }
}
