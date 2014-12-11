package uy.infocorp.banking.glass.controller.balance;

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
import com.google.android.glass.widget.Slider;
import com.google.common.collect.Lists;

import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;

public class ProductsBalanceActivity extends Activity {

    private List<CardBuilder> cards = Lists.newArrayList();
    private List<Product> products = Lists.newArrayList();
    private Product selectedProduct;

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
                startProductDetailIntent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startProductDetailIntent() {
        String alias = selectedProduct.getProductAlias();
    }

    private void showInitialView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Loading...")
                .setIcon(R.drawable.ic_sync)
                .getView();
        setContentView(initialView);
        Slider.Indeterminate indeterminate = Slider.from(initialView).startIndeterminate();
        indeterminate.show();
    }

    private void showNoProductsView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("No accounts registered yet")
                .setTimestamp("No Balances")
                .setIcon(R.drawable.ic_help)
                .getView();

        setContentView(initialView);
    }

    private void showErrorView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Unable to get the Accounts")
                .setFootnote("Check your internet connection")
                .setIcon(R.drawable.ic_warning)
                .getView();

        setContentView(initialView);
    }

    private void createCards() {
        new GetProductsTask(new FinishedTaskListener<List<Product>>() {
            @Override
            public void onResult(List<Product> products) {
                if (products == null) {
                    showErrorView();
                } else if (products.isEmpty()) {
                    showNoProductsView();
                } else {
                    ProductsBalanceActivity.this.products = products;

                    for (Product product : products) {
                        cards.add(createCard(product));
                    }
                    updateCardScrollView();
                }
            }
        }).execute();
    }


    private void updateCardScrollView() {
        ProductCardScrollAdapter adapter = new ProductCardScrollAdapter();

        CardScrollView cardScrollView = new CardScrollView(this);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                am.playSoundEffect(Sounds.TAP);

                selectedProduct = products.get(position);
                openOptionsMenu();
            }
        });

        setContentView(cardScrollView);
    }

    private CardBuilder createCard(Product product) {
        String alias = product.getProductAlias();
        String balance = product.getConsolidatedPositionBalance();
        String footnote = product.getProductNumber();
        String accountDescription = product.getProductTypeDescription();
        int iconId = product.getProductIconId();
        String timestamp = "just now";

        return new CardBuilder(this, CardBuilder.Layout.COLUMNS)
                .setText(accountDescription + "\n" + alias + "\n" + balance)
                .setFootnote(footnote)
                .setTimestamp(timestamp)
                .setIcon(iconId);
    }

    private class ProductCardScrollAdapter extends CardScrollAdapter {

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