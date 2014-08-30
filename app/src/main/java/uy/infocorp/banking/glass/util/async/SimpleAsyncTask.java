package uy.infocorp.banking.glass.util.async;

import android.os.AsyncTask;

public abstract class SimpleAsyncTask<T> extends AsyncTask<Object, Void, T>{

    private FinishedTaskListener listener;

    public SimpleAsyncTask(FinishedTaskListener<T> listener) {
        this.listener = listener;
    }

    @Override
    protected void onPostExecute(T result) {
        listener.onResult(result);
    }
}
