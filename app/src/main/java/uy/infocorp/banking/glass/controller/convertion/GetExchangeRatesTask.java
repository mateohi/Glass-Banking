package uy.infocorp.banking.glass.controller.convertion;

import android.util.Log;

import java.util.List;

import uy.infocorp.banking.glass.integration.publicapi.exchange.ExchangeRateClient;
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class GetExchangeRatesTask extends SimpleAsyncTask<List<ExchangeRateDTO>> {

    private static final String TAG = GetExchangeRatesTask.class.getSimpleName();

    public GetExchangeRatesTask(FinishedTaskListener<List<ExchangeRateDTO>> listener) {
        super(listener);
    }

    @Override
    protected List<ExchangeRateDTO> doInBackground(Object... params) {
        try {
            return ExchangeRateClient.instance().getExchangeRates();
        } catch (Exception e) {
            Log.e(TAG, "Unable to get list of Exchange Rates - " + e.getMessage());
            return null;
        }
    }
}
