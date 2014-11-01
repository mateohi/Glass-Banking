package uy.infocorp.banking.glass.controller.transactions;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
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

import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.model.transaction.Transaction;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;

public class LastTransactionsActivity extends Activity {

    private List<CardBuilder> cards = Lists.newArrayList();
    private List<Transaction> transactions = Lists.newArrayList();

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
                .setText("Unable to get closest ATMs")
                .setFootnote("Check your internet connection")
                .setIcon(R.drawable.ic_warning)
                .getView();

        setContentView(initialView);
    }

    private void createCards() {
        new GetLastTransactionsTask(new FinishedTaskListener<List<Transaction>>() {
            @Override
            public void onResult(List<Transaction> transactions) {
                if (transactions == null) {
                    showErrorView();
                }
                else if (transactions.isEmpty()) {
                    showNoTransactionsView();
                }
                else {
                    LastTransactionsActivity.this.transactions = transactions;

                    for (Transaction transaction : transactions) {
                        cards.add(createCard(transaction));
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

                Transaction selected = transactions.get(position);
                // openOptionsMenu(); y mostrale mas opciones como el de branches? o mas info de una ?
            }
        });

        setContentView(cardScrollView);
    }

    private CardBuilder createCard(Transaction transaction) {
        // TODO llenar bien los datos
        String text = "";
        String footnote = "";
        Bitmap image = null;

        return new CardBuilder(this, CardBuilder.Layout.CAPTION)
                .setText(text)
                .setFootnote(footnote)
                .addImage(image);
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
