package uy.infocorp.banking.glass.util.async;

public interface FinishedTaskListener<T> {

    public void onResult(T result);
}
