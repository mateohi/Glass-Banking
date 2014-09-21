package uy.infocorp.banking.glass.controller.branch;

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
import android.util.Log;
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

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.model.benefit.Branch;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;

public class ClosestBranchActivity extends Activity {

    private static final long METERS_BETWEEN_LOCATIONS = 2;
    private static final long MILLIS_BETWEEN_LOCATIONS = TimeUnit.SECONDS.toMillis(3);

    private List<CardBuilder> cards = new ArrayList<CardBuilder>();
    private List<Branch> branches = new ArrayList<Branch>();
    private Branch selectedBranch;
    private LocationManager locationManager;
    private Location location;
    private NumberFormat distanceFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        this.distanceFormat = NumberFormat.getNumberInstance();
        this.distanceFormat.setMinimumFractionDigits(0);
        this.distanceFormat.setMaximumFractionDigits(1);

        startLocationUpdates();

        showInitialView();
        createCards();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.closest_branch, menu);
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
        String uri = getResources().getString(R.string.maps_intent_uri, selectedBranch.getLatitude(),
                selectedBranch.getLongitude(), selectedBranch.getName());

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
                ClosestBranchActivity.this.location = location;
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
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Loading...")
                .setIcon(R.drawable.ic_sync)
                .getView();

        setContentView(initialView);
    }

    private void showNoBranchesView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("No branch found nearby")
                .setTimestamp("Try again later")
                .setIcon(R.drawable.ic_help)
                .getView();

        setContentView(initialView);
    }

    private void showErrorView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Unable to get closest ATMs")
                .setFootnote("Check your internet connection")
                .setIcon(R.drawable.ic_warning)
                .getView();

        setContentView(initialView);
    }

    private void createCards() {
        new GetClosestBranchesTask(new FinishedTaskListener<List<Branch>>() {
            @Override
            public void onResult(List<Branch> branches) {
                if (branches == null) {
                    showErrorView();
                }
                else if (branches.isEmpty()) {
                    showNoBranchesView();
                }
                else {
                    ClosestBranchActivity.this.branches = branches;

                    for (Branch branch : branches) {
                        cards.add(createCard(branch));
                    }
                    updateCardScrollView();
                }
            }
        }).execute(getLastLocation());
    }

    private Location getLastLocation() {
        if (this.location != null) {
            return this.location;
        }
        else {
            return locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        }
    }

    private void updateCardScrollView() {
        BranchCardScrollAdapter adapter = new BranchCardScrollAdapter();

        CardScrollView cardScrollView = new CardScrollView(this);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                am.playSoundEffect(Sounds.TAP);

                selectedBranch = branches.get(position);
                openOptionsMenu();
            }
        });

        setContentView(cardScrollView);
    }

    private CardBuilder createCard(Branch branch) {
        // TODO llenar bien los datos, incluyendo puntaje
        String text = branch.getName();
        String footnote = branch.getTelephone();
        String timestamp = this.distanceFormat.format(branch.getDistance()) + "km";
        Bitmap image = branch.getImage();

        return new CardBuilder(this, CardBuilder.Layout.CAPTION)
                .setText(text)
                .setFootnote(footnote)
                .setTimestamp(timestamp)
                .addImage(image);
    }

    private class BranchCardScrollAdapter extends CardScrollAdapter {

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
        public int getItemViewType(int position){
            return cards.get(position).getItemViewType();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return cards.get(position).getView(convertView, parent);
        }
    }
}