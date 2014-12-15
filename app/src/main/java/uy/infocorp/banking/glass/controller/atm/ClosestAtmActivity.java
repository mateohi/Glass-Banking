package uy.infocorp.banking.glass.controller.atm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;
import com.google.android.glass.widget.Slider;
import com.google.common.collect.Lists;

import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.model.benefit.Atm;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.format.DistanceFormat;

public class ClosestAtmActivity extends Activity {

    private static final long METERS_BETWEEN_LOCATIONS = 2;
    private static final long MILLIS_BETWEEN_LOCATIONS = TimeUnit.SECONDS.toMillis(3);

    private List<CardBuilder> cards = Lists.newArrayList();
    private List<Atm> atms = Lists.newArrayList();
    private Slider.Indeterminate slider;
    private Atm selectedAtm;
    private LocationManager locationManager;
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        startLocationUpdates();
        showInitialView();
        createCards();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.closest_atm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_stop:
                finish();
                return true;
            case R.id.action_get_directions:
                startMapIntent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startMapIntent() {
        String uri = getResources().getString(R.string.maps_intent_uri, selectedAtm.getLatitude(),
                selectedAtm.getLongitude(), selectedAtm.getName());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mapIntent.setData(Uri.parse(uri));

        startActivity(mapIntent);
    }

    private void startLocationUpdates() {
        this.locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(false);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                ClosestAtmActivity.this.location = location;
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        List<String> providers = locationManager.getProviders(criteria, true);
        for (String provider : providers) {
            locationManager.requestLocationUpdates(provider, MILLIS_BETWEEN_LOCATIONS,
                    METERS_BETWEEN_LOCATIONS, locationListener, Looper.getMainLooper());
        }
    }

    private void showInitialView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.MENU)
                .setText("Getting closest ATMs")
                .setIcon(R.drawable.ic_sync)
                .getView();

        this.slider = Slider.from(initialView).startIndeterminate();

        setContentView(initialView);
    }

    private void showNoAtmsView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("No ATM found nearby")
                .setIcon(R.drawable.ic_help)
                .getView();

        setContentView(initialView);
    }

    private void showNoConnectivityView() {
        View errorView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Unable to get closest ATMs")
                .setFootnote("Check your internet connection")
                .setIcon(R.drawable.ic_cloud_sad_150)
                .getView();

        setContentView(errorView);
    }

    private void showNoLocationView() {
        View errorView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Unable to get current location")
                .setFootnote("Try connecting Glass to your phone")
                .setIcon(R.drawable.ic_warning_150)
                .getView();

        setContentView(errorView);
    }

    private void createCards() {
        Location lastKnownLocation = getLastLocation();

        if (lastKnownLocation == null) {
            showNoLocationView();
        } else {
            new GetClosestAtmsTask(new FinishedTaskListener<List<Atm>>() {
                @Override
                public void onResult(List<Atm> atms) {
                    slider.hide();
                    slider = null;

                    if (atms == null) {
                        showNoConnectivityView();
                    } else if (atms.isEmpty()) {
                        showNoAtmsView();
                    } else {
                        ClosestAtmActivity.this.atms = atms;

                        for (Atm atm : atms) {
                            cards.add(createCard(atm));
                        }
                        updateCardScrollView();
                    }
                }
            }).execute(lastKnownLocation);
        }
    }

    private Location getLastLocation() {
        if (this.location != null) {
            return this.location;
        } else {
            return locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        }
    }

    private void updateCardScrollView() {
        CardScrollAdapter adapter = new AtmCardScrollAdapter();

        CardScrollView cardScrollView = new CardScrollView(this);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                am.playSoundEffect(Sounds.TAP);

                selectedAtm = atms.get(position);
                openOptionsMenu();
            }
        });

        setContentView(cardScrollView);
    }

    private CardBuilder createCard(Atm atm) {
        // TODO llenar bien los datos, incluyendo puntaje
        String text = atm.getName();
        String timestamp = DistanceFormat.from(atm.getDistance()) + "km";
        Bitmap image = atm.getImage();

        return new CardBuilder(this, CardBuilder.Layout.CAPTION)
                .setText(text)
                .setTimestamp(timestamp)
                .addImage(image);
    }

    private class AtmCardScrollAdapter extends CardScrollAdapter {

        @Override
        public int getPosition(Object item) {
            return cards.indexOf(item);
        }

        @Override
        public int getCount() {
            return cards.size();
        }

        @Override
        public Object getItem(int position) {
            return cards.get(position);
        }

        @Override
        public int getViewTypeCount() {
            return CardBuilder.getViewTypeCount();
        }

        @Override
        public int getItemViewType(int position) {
            return cards.get(position).getItemViewType();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return cards.get(position).getView(convertView, parent);
        }
    }
}
