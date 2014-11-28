package uy.infocorp.banking.glass.controller.messaging;

import android.util.Log;

import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.messaging.Message;
import uy.infocorp.banking.glass.integration.privateapi.messaging.MessagingClient;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class GetMessagesTask extends SimpleAsyncTask<List<Message>> {

    private static final String TAG = GetMessagesTask.class.getSimpleName();

    public GetMessagesTask(FinishedTaskListener<List<Message>> listener) {
        super(listener);
    }

    @Override
    protected List<Message> doInBackground(Object... params) {
        try {
            String authToken = (String) params[0];
            return MessagingClient.instance().getInboxMessages(authToken);
        } catch (Exception e) {
            Log.e(TAG, "Unable to get list of Messages -" + e.getMessage());
            return null;
        }
    }
}