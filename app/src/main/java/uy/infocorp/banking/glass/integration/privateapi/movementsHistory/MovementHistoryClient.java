package uy.infocorp.banking.glass.integration.privateapi.movementsHistory;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.movements.Movement;
import uy.infocorp.banking.glass.integration.privateapi.movementsHistory.dto.MovementHistoryResponseDTO;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.offline.OfflineResourceUtils;

public class MovementHistoryClient {

    private static final String TAG = MovementHistoryClient.class.getSimpleName();
    private static final String X_AUTH_TOKEN_HEADER_NAME = OfflineResourceUtils.getString(R.string.x_auth_header);

    private static MovementHistoryClient instance;
    private RestExecutionBuilder builder;

    private MovementHistoryClient() {
        builder = RestExecutionBuilder.get();
    }

    public static MovementHistoryClient instance() {
        if (instance == null) {
            instance = new MovementHistoryClient();
        }
        return instance;
    }

    public List<Movement> getLastMovements(String authToken) throws Exception {
        if (OfflineResourceUtils.offline()) {
            // TODO
            throw new UnsupportedOperationException("Not implemented yet");
        }

        String formattedUrl = MovementHistoryUtils.buildFormattedUrl();
        Header tokenHeader = new BasicHeader(X_AUTH_TOKEN_HEADER_NAME, authToken);

        MovementHistoryResponseDTO response = this.builder
                .appendUrl(formattedUrl)
                .appendHeader(tokenHeader)
                .execute(MovementHistoryResponseDTO.class);
        
        Movement[] movements = response.getItems();

        return MovementHistoryUtils.getCorrectedMovements(movements);
    }


}
