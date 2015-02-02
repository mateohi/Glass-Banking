package uy.infocorp.banking.glass.domain.arrival.builder;

import uy.infocorp.banking.glass.integration.publicapi.branch.dto.BranchArrivalRequestDTO;

public class BranchArrivalBuilder {

    public static BranchArrivalRequestDTO from(String id) {
        BranchArrivalRequestDTO request = new BranchArrivalRequestDTO();
        request.setBeaconIdentifier(id);

        return request;
    }
}
