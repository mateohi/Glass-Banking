package uy.infocorp.banking.glass.controller.exchange;

import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.LiveCard.PublishMode;
import com.google.android.glass.widget.CardBuilder;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.IBinder;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.PublicApiService;
import uy.infocorp.banking.glass.integration.publicapi.exchange.ExchangeRateClient;
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;
import uy.infocorp.banking.glass.util.view.dialog.GlassDialog;

public class ExchangeRateService extends Service {

    private static final String TAG = ExchangeRateService.class.getSimpleName();

    private static final int INITIAL_DELAY = 0;
    private static final int TASK_DELAY = 5;

    private ScheduledExecutorService task;

    private LiveCard liveCard;
    private List<ExchangeRateDTO> exchangeRates = new ArrayList<ExchangeRateDTO>();
    private boolean firstRates;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (liveCard == null) {
            this.firstRates = true;
            this.liveCard = new LiveCard(this, TAG);

            loadInitialView();

            Intent menuIntent = new Intent(this, ExchangeRateMenuActivity.class);
            this.liveCard.setAction(PendingIntent.getActivity(this, 0, menuIntent, 0));
            this.liveCard.publish(PublishMode.REVEAL);

            createAndStartScheduledTask();
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
        this.task.shutdown();
    }

    private void loadInitialView() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_sync);

        RemoteViews remoteViews = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Loading")
                .setFootnote("Waiting for exchange rates")
                .setIcon(bitmap)
                .getRemoteViews();

        this.liveCard.setViews(remoteViews);
    }

    private void loadErrorView() {
        GlassDialog.warning(this.getApplicationContext(), "Unable to get exchange rates",
                "Check your internet connection");
        destroy();
    }

    private void updateView() {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.exchange_rate);

        RemoteViews header = new RemoteViews(getPackageName(), R.layout.exchange_rate_header);
        remoteViews.addView(R.id.content, header);

        createNestedViews(remoteViews, 0);
        //remoteViews.setScrollPosition(R.id.nested, 10);
        this.liveCard.setViews(remoteViews);
    }

    private void createNestedViews(RemoteViews parent, int position) {
        if (position < this.exchangeRates.size()) {
            RemoteViews row = createRowRemoteView(position);

            RemoteViews nested = new RemoteViews(getPackageName(), R.layout.exchange_rate);
            nested.addView(R.id.content, row);
            parent.addView(R.id.nested, nested);

            createNestedViews(parent, ++position);
        }
    }

    private RemoteViews createRowRemoteView(int position) {
        ExchangeRateDTO exchangeRate = this.exchangeRates.get(position);

        String description = exchangeRate.getDestinationCurrencyDTO().getCurrencyDescription();
        String alphaCode = exchangeRate.getDestinationCurrencyDTO().getCurrencyAlpha3Code();
        String buy = exchangeRate.getBuyRate();
        String sell = exchangeRate.getSellRate();

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

    private void createAndStartScheduledTask() {
        this.task = Executors.newSingleThreadScheduledExecutor();

        this.task.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    String alphaCode = "UYU";
                    exchangeRates = ExchangeRateClient.instance().getExchangeRatesByAlpha3Code(alphaCode);
                    updateView();

                    firstRates = false;
                }
                catch (Exception e) {
                    if (firstRates) {
                        loadErrorView();
                    }
                    // else -> No update, no need to throw an error, we just show older rates
                }
            }
        }, INITIAL_DELAY, TASK_DELAY, TimeUnit.MINUTES);
    }

}
