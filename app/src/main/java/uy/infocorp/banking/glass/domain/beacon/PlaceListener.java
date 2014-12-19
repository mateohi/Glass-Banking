package uy.infocorp.banking.glass.domain.beacon;

public interface PlaceListener {

    public void onEntered(int placeId);

    public void onExit(int placeId);
}
