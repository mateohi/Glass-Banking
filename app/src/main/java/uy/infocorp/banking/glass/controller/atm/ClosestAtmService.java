package uy.infocorp.banking.glass.controller.atm;

import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.LiveCard.PublishMode;
import com.google.android.glass.widget.CardBuilder;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

public class ClosestAtmService extends Service {

    private static final String LIVE_CARD_TAG = ClosestAtmService.class.getSimpleName();

    private LiveCard liveCard;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (liveCard == null) {
            liveCard = new LiveCard(this, LIVE_CARD_TAG);

            liveCard.setViews(buildRemoteViews());

            Intent menuIntent = new Intent(this, ClosestAtmMenuActivity.class);
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

    private RemoteViews buildRemoteViews() {
        return new CardBuilder(getApplicationContext(), CardBuilder.Layout.MENU)
                .setText("TEST")
                .getRemoteViews();
    }
}
