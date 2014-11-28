package uy.infocorp.banking.glass.util.http;

import uy.infocorp.banking.glass.util.resources.ResourceUtils;

/**
 * Created by german on 28/11/2014.
 */
public abstract class BaseClient {

    public abstract Object getOffline();

    public abstract Object getOnline();

    public Object execute() {
        if (ResourceUtils.offline()) {
            return this.getOffline();
        } else {
            return this.getOnline();
        }
    }
}
