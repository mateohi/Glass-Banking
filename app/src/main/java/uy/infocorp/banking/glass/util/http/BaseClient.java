package uy.infocorp.banking.glass.util.http;

import uy.infocorp.banking.glass.util.resources.Resources;

public abstract class BaseClient {

    protected abstract Object getOffline();

    protected abstract Object getOnline();

    public Object execute() {
        if (Resources.offline()) {
            return this.getOffline();
        } else {
            return this.getOnline();
        }
    }
}
