package uy.infocorp.banking.glass.controller.transactions;

import android.app.Activity;
import android.content.Context;
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
import com.google.common.collect.Lists;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;

public class LastTransactionsActivity extends Activity {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/YYYY");

    private List<CardBuilder> cards = Lists.newArrayList();
    private List<Transfer> transfers = Lists.newArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showInitialView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Loading...")
                .setIcon(R.drawable.ic_sync)
                .getView();

        setContentView(initialView);
    }

    private void showNoTransactionsView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("No transactions found")
                .setIcon(R.drawable.ic_help)
                .getView();

        setContentView(initialView);
    }

    private void showErrorView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Unable to get last transactions")
                .setFootnote("Check your internet connection")
                .setIcon(R.drawable.ic_warning)
                .getView();

        setContentView(initialView);
    }

    private void createCards() {
        new GetLastTransactionsTask(new FinishedTaskListener<List<Transfer>>() {
            @Override
            public void onResult(List<Transfer> transfers) {
                if (transfers == null) {
                    showErrorView();
                }
                else if (transfers.isEmpty()) {
                    showNoTransactionsView();
                }
                else {
                    LastTransactionsActivity.this.transfers = transfers;

                    for (Transfer transfer : transfers) {
                        cards.add(createCard(transfer));
                    }
                    updateCardScrollView();
                }
            }
        }).execute();
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
                // openOptionsMenu(); y mostrale mas opciones como el de branches? o mas info de una ?
            }
        });

        setContentView(cardScrollView);
    }

    private CardBuilder createCard(Transfer transfer) {
        // TODO llenar bien los datos
        int icon = getIconFromTransferType(transfer);
        String text = transfer.getDebitProduct().getProductAlias() + " - "
                + transfer.getCreditProduct().getProductAlias();
        String timestamp = DATE_FORMAT.format(transfer.getCreatedDate());
        String footnote = transfer.getCurrency().getCurrencySymbol() + " "
                + transfer.getAmount().toString();

        return new CardBuilder(this, CardBuilder.Layout.COLUMNS_FIXED)
                .setIcon(icon)
                .setText(text)
                .setTimestamp(timestamp)
                .setFootnote(footnote);
    }

    private int getIconFromTransferType(Transfer transfer) {
        // TODO Agarrar el tipo de transferencia y mostrar diferentes iconos
        return R.drawable.logo_ic;
    }

    private class TransactionCardScrollAdapter extends CardScrollAdapter {

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
