package uy.infocorp.banking.glass.controller.exchange;

import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.LiveCard.PublishMode;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.icbankingglass.R;
import uy.infocorp.banking.glass.integration.publicapi.PublicApiService;
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;

public class ExchangeRateService extends Service {

    private static final String TAG = ExchangeRateService.class.getSimpleName();

    private static final int INITIAL_DELAY = 0;
    private static final int TASK_DELAY = 5;

    private ScheduledExecutorService task;

    private LiveCard liveCard;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (liveCard == null) {
            liveCard = new LiveCard(this, TAG);

            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.exchange_rate);
            liveCard.setViews(remoteViews);

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

    private void createAndStartScheduledTask() {
        task = Executors.newSingleThreadScheduledExecutor();

        task.scheduleAtFixedRate(new Runnable() {
            public void run() {
                String alphaCode = "UYU";
                StringBuilder sb = new StringBuilder();
                List<ExchangeRateDTO> exchangeRates = PublicApiService.getExchangeRatesByAlpha3Code(alphaCode);
                for (ExchangeRateDTO exchangeRate : exchangeRates) {
                    String sourceSymbol = exchangeRate.getSourceCurrencyDTO().getCurrencySymbol();
                    String destinationSymbol = exchangeRate.getDestinationCurrencyDTO().getCurrencySymbol();
                    String buy = exchangeRate.getBuyRate();
                    String sell = exchangeRate.getSellRate();
                    sb.append(sourceSymbol);
                    sb.append("-");
                    sb.append(destinationSymbol);
                    sb.append(" : Buy ");
                    sb.append(buy);
                    sb.append(" Sell ");
                    sb.append(sell);
                    sb.append('\n');
                }
                String mostrar = sb.toString();
            }
        }, INITIAL_DELAY, TASK_DELAY, TimeUnit.MINUTES);
    }

}
