package uy.infocorp.banking.glass.controller.balance;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.glass.widget.CardBuilder;

import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;

/**
 * Created by german on 02/11/2014.
 */
public class ProductsBalanceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.account_balance, menu);
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
/*        String uri = getResources().getString(R.string.maps_intent_uri, selectedBranch.getLatitude(),
                selectedBranch.getLongitude(), selectedBranch.getName());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mapIntent.setData(Uri.parse(uri));

        startActivity(mapIntent);*/
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
                .setText("No accounts registered yet")
                .setTimestamp("No Balances")
                .setIcon(R.drawable.ic_help)
                .getView();

        setContentView(initialView);
    }

    private void showErrorView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Unable to get the Account Balances")
                .setFootnote("Check your internet connection")
                .setIcon(R.drawable.ic_warning)
                .getView();

        setContentView(initialView);
    }

    private void createCards() {
/*        new GetClosestBranchesTask(new FinishedTaskListener<List<Branch>>() {
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
        }).execute(getLastLocation());*/
    }

    private CardBuilder createCard(Product product) {
        // TODO llenar bien los datos, incluyendo puntaje
        String text = product.getProductAlias();
        String footnote = product.getProductNumber();
        String timestamp = "timestam[";//this.distanceFormat.format(branch.getDistance()) + "km";
        Bitmap image = null;//product.getImage();

        return new CardBuilder(this, CardBuilder.Layout.CAPTION)
                .setText(text)
                .setFootnote(footnote)
                .setTimestamp(timestamp)
                .addImage(image);
    }

}
