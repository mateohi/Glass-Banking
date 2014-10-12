package uy.infocorp.banking.glass.domain.beacon;

public interface PlaceListener {

    public void onEntered(String placeId);

    public void onExit(String placeId);
}
