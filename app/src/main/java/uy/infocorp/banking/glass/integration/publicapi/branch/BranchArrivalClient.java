package uy.infocorp.banking.glass.integration.publicapi.branch;

import org.apache.http.Header;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.publicapi.branch.dto.BranchArrivalRequestDTO;
import uy.infocorp.banking.glass.util.http.HttpUtils;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.http.VoidBaseClient;

public class BranchArrivalClient extends VoidBaseClient {

    private static BranchArrivalClient instance;
    private RestExecutionBuilder builder;

    private BranchArrivalRequestDTO request;

    private BranchArrivalClient() {
        builder = RestExecutionBuilder.post(PrivateUrls.POST_BRANCH_ARRIVAL);
    }

    public static BranchArrivalClient instance() {
        if (instance == null) {
            instance = new BranchArrivalClient();
        }

        return instance;
    }

    public void informArrival(BranchArrivalRequestDTO request, String authToken) {
        this.request = request;

        if (authToken != null) {
            Header authHeader = HttpUtils.buildTokenHeader(authToken);
            this.builder.appendHeader(authHeader);
        }

        this.execute();
    }

    @Override
    protected void getOnlineVoid() {
        builder.appendObjectBody(request).execute();
    }
}
