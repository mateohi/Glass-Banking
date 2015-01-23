package uy.infocorp.banking.glass.integration.privateapi.movementsHistory;

import org.apache.http.Header;

import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.ProductType;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.movements.Movement;
import uy.infocorp.banking.glass.integration.privateapi.movementsHistory.dto.MovementHistoryResponseDTO;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.HttpUtils;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.Resources;

public class MovementHistoryClient extends BaseClient {

    private static MovementHistoryClient instance;
    private RestExecutionBuilder builder;
    private String authToken;
    private String productBankIdentifier;
    private ProductType productType;

    private MovementHistoryClient() {
        builder = RestExecutionBuilder.get();
    }

    public static MovementHistoryClient instance() {
        if (instance == null) {
            instance = new MovementHistoryClient();
        }
        return instance;
    }

    public List<Movement> getLastMovements(String authToken, ProductType productType,
                                           String productBankIdentifier) throws Exception {
        this.authToken = authToken;
        this.productType = productType;
        this.productBankIdentifier = productBankIdentifier;
        return (List<Movement>) this.execute();
    }


    @Override
    protected Object getOffline() {
        Movement[] movements = Resources.jsonToObject(R.raw.movements, Movement[].class);
        return MovementHistoryUtils.getCorrectedMovements(movements);
    }

    @Override
    protected Object getOnline() {
        String formattedUrl = MovementHistoryUtils.buildFormattedUrl();
        Header tokenHeader = HttpUtils.buildTokenHeader(authToken);

        MovementHistoryResponseDTO response = this.builder
                .appendUrl(formattedUrl)
                .appendHeader(tokenHeader)
                .execute(MovementHistoryResponseDTO.class);

        Movement[] movements = response.getItems();

        return MovementHistoryUtils.getCorrectedMovements(movements);
    }
}
