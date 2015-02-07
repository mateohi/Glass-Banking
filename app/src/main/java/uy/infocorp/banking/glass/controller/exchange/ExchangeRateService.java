package uy.infocorp.banking.glass.controller.exchange;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.LiveCard.PublishMode;
import com.google.android.glass.widget.CardBuilder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.exchange.ExchangeRateClient;
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;
import uy.infocorp.banking.glass.util.format.PriceFormat;
import uy.infocorp.banking.glass.util.view.dialog.GlassDialog;

public class ExchangeRateService extends Service {

    private static final String TAG = ExchangeRateService.class.getSimpleName();
    private static final int RATES_TO_SHOW = 4;

    // Task for updating rates values over time
    private static final int VALUES_TASK_INITIAL_DELAY = 0;
    private static final int VALUES_TASK_DELAY = 5;

    private ScheduledExecutorService updateRatesTask;

    // Task for updating rates view
    private static final int VIEW_TASK_DELAY = 3;

    private ScheduledExecutorService updateRatesViewTask;

    private LiveCard liveCard;
    private List<ExchangeRateDTO> exchangeRates = Collections.<ExchangeRateDTO> synchronizedList(Lists.<ExchangeRateDTO>newArrayList());
    private boolean firstRates;
    private String alphaCode;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (liveCard == null) {
            alphaCode = getResources().getString(R.string.alpha_code);

            this.firstRates = true;
            this.liveCard = new LiveCard(this, TAG);

            loadInitialView();

            Intent menuIntent = new Intent(this, ExchangeRateMenuActivity.class);
            this.liveCard.setAction(PendingIntent.getActivity(this, 0, menuIntent, 0));
            this.liveCard.publish(PublishMode.REVEAL);

            createAndStartValuesTask();
            createAndStartViewTask();
        } else {
            this.liveCard.navigate();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        destroy();
        super.onDestroy();
    }

    private void destroy() {
        if (this.liveCard != null && this.liveCard.isPublished()) {
            this.liveCard.unpublish();
            this.liveCard = null;
        }
        this.updateRatesTask.shutdown();
    }

    private void loadInitialView() {
        RemoteViews remoteViews = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Loading")
                .setFootnote("Waiting for exchange rates")
                .setIcon(R.drawable.ic_sync)
                .getRemoteViews();

        this.liveCard.setViews(remoteViews);
    }

    private void loadErrorView() {
        GlassDialog.warning(this.getApplicationContext(), "Unable to get exchange rates",
                "Check your internet connection");
        destroy();
    }

    private void updateView() {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.exchange_rates);

        RemoteViews rates = new RemoteViews(getPackageName(), R.layout.exchange_rate_nested);
        createNestedViews(rates);
        remoteViews.addView(R.id.exchange_rates, rates);

        this.liveCard.setViews(remoteViews);
    }

    private void createNestedViews(RemoteViews parent) {
        for (int i = 0; i < RATES_TO_SHOW; i++) {
            RemoteViews row = createRowRemoteView(i);

            RemoteViews nested = new RemoteViews(getPackageName(), R.layout.exchange_rate_nested);
            nested.addView(R.id.content, row);
            parent.addView(R.id.nested, nested);
        }
    }

    private RemoteViews createRowRemoteView(int position) {
        ExchangeRateDTO exchangeRate = this.exchangeRates.get(position);

        String description = exchangeRate.getDestinationCurrency().getCurrencyDescription();
        String alphaCode = exchangeRate.getDestinationCurrency().getCurrencyAlpha3Code();
        String buy = PriceFormat.parseDefault(exchangeRate.getBuyRate());
        String sell = PriceFormat.parseDefault(exchangeRate.getSellRate());

        int color = position % 2 == 0 ? Color.GRAY : Color.WHITE;

        RemoteViews row = new RemoteViews(getPackageName(), R.layout.exchange_rate_row);
        row.setTextViewText(R.id.exchange_currency_description, description);
        row.setTextViewText(R.id.exchange_currency_symbol, alphaCode);
        row.setTextViewText(R.id.exchange_rate_buy, buy);
        row.setTextViewText(R.id.exchange_rate_sell, sell);

        row.setTextColor(R.id.exchange_currency_description, color);
        row.setTextColor(R.id.exchange_currency_symbol, color);
        row.setTextColor(R.id.exchange_rate_buy, color);
        row.setTextColor(R.id.exchange_rate_sell, color);

        return row;
    }

    private void createAndStartValuesTask() {
        this.updateRatesTask = Executors.newSingleThreadScheduledExecutor();

        this.updateRatesTask.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    exchangeRates = ExchangeRateClient.instance().getExchangeRatesByAlpha3Code(alphaCode);
                    updateView();

                    firstRates = false;
                } catch (Exception e) {
                    if (firstRates) {
                        loadErrorView();
                    }
                    // else -> No update, no need to throw an error, we just show older rates
                }
            }
        }, VALUES_TASK_INITIAL_DELAY, VALUES_TASK_DELAY, TimeUnit.MINUTES);
    }

    private void createAndStartViewTask() {
        this.updateRatesViewTask = Executors.newSingleThreadScheduledExecutor();

        this.updateRatesViewTask.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    flipExchangeRates();
                    updateView();
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }, VIEW_TASK_DELAY, VIEW_TASK_DELAY, TimeUnit.SECONDS);
    }

    private void flipExchangeRates() {
        Log.i(TAG, Arrays.toString(exchangeRates.toArray()));
        ExchangeRateDTO last = Iterables.getLast(exchangeRates);
        List<ExchangeRateDTO> restList = exchangeRates.subList(0, exchangeRates.size() - 1);
        ExchangeRateDTO[] rest = restList.toArray(new ExchangeRateDTO[restList.size()]);

        this.exchangeRates = Lists.asList(last, rest);
        Log.i(TAG, Arrays.toString(exchangeRates.toArray()));
    }

}
