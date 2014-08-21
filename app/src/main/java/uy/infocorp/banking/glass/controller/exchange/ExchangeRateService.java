package uy.infocorp.banking.glass.controller.exchange;

import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.LiveCard.PublishMode;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import uy.infocorp.banking.glass.icbankingglass.R;

public class ExchangeRateService extends Service {

    private static final String TAG = ExchangeRateService.class.getSimpleName();

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
        super.onDestroy();
    }
}
