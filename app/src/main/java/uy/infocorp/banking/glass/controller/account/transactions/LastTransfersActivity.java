package uy.infocorp.banking.glass.controller.account.transactions;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
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

import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.controller.account.ProductsBalanceActivity;
import uy.infocorp.banking.glass.controller.common.ExtendedActivity;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.ProductType;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.date.DateUtils;
import uy.infocorp.banking.glass.util.resources.Resources;
import uy.infocorp.banking.glass.util.serialization.EnumUtil;

public class LastTransfersActivity extends ExtendedActivity {

    private List<View> views = Lists.newArrayList();
    private List<Transfer> transfers = Lists.newArrayList();
    private Slider.Indeterminate slider;
    private String productBankIdentifier;
    private String sourceAccountAlias;
    private String authToken;
    private ProductType productType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        analyzeIntent();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        showInitialView();
        createCards();
    }

    private void analyzeIntent() {
        Intent intent = getIntent();

        this.productBankIdentifier = intent.getStringExtra(ProductsBalanceActivity.PRODUCT_BANK_IDENTIFIER);
        this.sourceAccountAlias = intent.getStringExtra(ProductsBalanceActivity.PRODUCT_ALIAS);
        this.authToken = intent.getStringExtra(ProductsBalanceActivity.AUTH_TOKEN);
        this.productType = EnumUtil.deserialize(ProductType.class).from(intent);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showInitialView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.MENU)
                .setText("Loading transfers ...")
                .setIcon(R.drawable.ic_sync)
                .getView();

        this.slider = Slider.from(initialView).startIndeterminate();

        setContentView(initialView);
    }

    private void showNoTransactionsView() {
        View noTransactionsView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("No transfers found")
                .setIcon(R.drawable.ic_help)
                .getView();

        setContentView(noTransactionsView);
    }

    private void showNoConnectivityView() {
        View errorView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Unable to get last transfers")
                .setFootnote("Check your internet connection")
                .setIcon(R.drawable.ic_cloud_sad_150)
                .getView();

        setContentView(errorView);
    }

    private void createCards() {
        new GetLastTransfersTask(new FinishedTaskListener<List<Transfer>>() {
            @Override
            public void onResult(List<Transfer> transfers) {
                slider.hide();
                slider = null;

                if (transfers == null) {
                    showNoConnectivityView();
                    delayedFinish(3);
                } else if (transfers.isEmpty()) {
                    showNoTransactionsView();
                    delayedFinish(3);
                } else {
                    LastTransfersActivity.this.transfers = transfers;

                    for (Transfer transfer : transfers) {
                        views.add(createView(transfer));
                    }
                    updateCardScrollView();
                }
            }
        }).execute(this.authToken, this.productBankIdentifier, this.productType);
    }

    private void updateCardScrollView() {
        TransactionCardScrollAdapter adapter = new TransactionCardScrollAdapter();

        CardScrollView cardScrollView = new CardScrollView(this);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                am.playSoundEffect(Sounds.TAP);

                Transfer selected = transfers.get(position);
                // TODO openOptionsMenu(); y mostrale mas opciones como el de branches? o mas info de una ?
            }
        });

        setContentView(cardScrollView);
    }

    private View createView(Transfer transfer) {
        String transferDate = DateUtils.simpleMonthDateFormat(transfer.getCreatedDate());
        String amount = Resources.getString(R.string.alpha_symbol) + " " + transfer.getAmount().toString();

        View convertView = getLayoutInflater().inflate(R.layout.transaction_history_item, null);

        setTextViewText(convertView, R.id.timestamp, transferDate);
        setTextViewText(convertView, R.id.text_view_top_left_title, sourceAccountAlias);
        setTextViewText(convertView, R.id.text_view_bottom_left_title, transfer.getCreditProduct().getProductNumber());
        setTextViewText(convertView, R.id.text_view_right_title, amount);
        setTextViewText(convertView, R.id.text_view_top_right_title, transfer.getDescription());

        return convertView;
    }

    private int getIconFromTransferType(Transfer transfer) {
        // TODO Agarrar el tipo de transferencia y mostrar diferentes iconos
        return R.drawable.logo_ic;
    }

    private class TransactionCardScrollAdapter extends CardScrollAdapter {

        @Override
        public int getPosition(Object item) {
            return views.indexOf(item);
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public Object getItem(int position) {
            return views.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return views.get(position);
        }
    }
}
