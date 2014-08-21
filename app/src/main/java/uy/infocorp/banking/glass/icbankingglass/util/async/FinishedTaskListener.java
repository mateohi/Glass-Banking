package uy.infocorp.banking.glass.icbankingglass.util.async;

public interface FinishedTaskListener<T> {

    public void onResult(T result);
}
