package uy.infocorp.banking.glass.util.async;

import android.content.Context;
import android.os.AsyncTask;

import uy.infocorp.banking.glass.integration.Constants;

public abstract class OfflineModeAsyncTask<T> extends AsyncTask<Object, Void, T> {

    protected Context context;
    private FinishedTaskListener listener;

    protected abstract T doOffline();

    protected abstract T doOnline(Object... params);

    public OfflineModeAsyncTask(Context context, FinishedTaskListener<T> listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected T doInBackground(Object... params) {
        if (Constants.OFFLINE_MODE) {
            return doOffline();
        } else {
            return doOnline(params);
        }
    }

    @Override
    protected void onPostExecute(T result) {
        listener.onResult(result);
    }
}
