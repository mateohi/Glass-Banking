package uy.infocorp.banking.glass.util.http;

public abstract class VoidBaseClient extends BaseClient {

    protected abstract void getOnlineVoid();

    @Override
    protected Object getOffline() {
        return null;
    }

    @Override
    protected Object getOnline() {
        getOnlineVoid();
        return null;
    }

}
