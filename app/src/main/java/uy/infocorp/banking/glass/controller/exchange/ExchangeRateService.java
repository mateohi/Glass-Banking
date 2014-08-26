package uy.infocorp.banking.glass.controller.exchange;

import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.LiveCard.PublishMode;

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
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;

public class ExchangeRateService extends Service {

    private static final String TAG = ExchangeRateService.class.getSimpleName();

    private static final int INITIAL_DELAY = 0;
    private static final int TASK_DELAY = 5;

    private ScheduledExecutorService task;

    private LiveCard liveCard;
    private List<ExchangeRateDTO> exchangeRates = new ArrayList<ExchangeRateDTO>();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (liveCard == null) {
            liveCard = new LiveCard(this, TAG);

            loadInitialView();

            Intent menuIntent = new Intent(this, ExchangeRateMenuActivity.class);
            liveCard.setAction(PendingIntent.getActivity(this, 0, menuIntent, 0));
            liveCard.publish(PublishMode.REVEAL);

            createAndStartScheduledTask();
        } else {
            liveCard.navigate();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (liveCard != null && liveCard.isPublished()) {
            liveCard.unpublish();
            liveCard = null;
        }
        task.shutdown();
        super.onDestroy();
    }

    private void loadInitialView() {
        setLeftImageView(R.drawable.ic_sync, "Loading exchange rates ...");
    }

    private void loadErrorView() {
        setLeftImageView(R.drawable.ic_warning_150, "Unable to get rates");
    }

    private void setLeftImageView(int resourceId, String text) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.left_column_image);
        remoteViews.setImageViewBitmap(R.id.left_column_image_image, bitmap);
        remoteViews.setTextViewText(R.id.left_column_image_content, text);

        liveCard.setViews(remoteViews);
    }

    private void updateView() {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.exchange_rate);

        RemoteViews header = new RemoteViews(getPackageName(), R.layout.exchange_rate_header);
        remoteViews.addView(R.id.content, header);

        createNestedViews(remoteViews, 0);
        //remoteViews.setScrollPosition(R.id.nested, 10);
        liveCard.setViews(remoteViews);
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
        task = Executors.newSingleThreadScheduledExecutor();

        task.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    String alphaCode = "UYU";
                    exchangeRates = PublicApiService.getExchangeRatesByAlpha3Code(alphaCode);
                    updateView();
                }
                catch (Exception e) {
                    loadErrorView();
                }
            }
        }, INITIAL_DELAY, TASK_DELAY, TimeUnit.MINUTES);
    }

}
