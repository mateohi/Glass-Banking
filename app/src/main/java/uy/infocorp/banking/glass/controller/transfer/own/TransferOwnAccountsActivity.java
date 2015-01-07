package uy.infocorp.banking.glass.controller.transfer.own;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;
import com.google.android.glass.widget.Slider;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.controller.common.EditableActivity;
import uy.infocorp.banking.glass.controller.common.product.GetProductsTask;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.resources.Resources;

public class TransferOwnAccountsActivity extends EditableActivity {

    private static final String CURRENCY_SYMBOL = Resources.getString(R.string.alpha_symbol);

    private GestureDetector gestureDetector;
    private Menu menu;

    private List<CardBuilder> cards = Lists.newArrayList();
    private List<Product> products = Lists.newArrayList();

    private Product debitProduct;
    private Product creditProduct;
    private Slider.Indeterminate slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.gestureDetector = createGestureDetector();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        showInitialView();
        createDebitProductCards();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        inflateMenu(R.menu.transfer);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_stop:
                finish();
                return true;
            case R.id.action_transfer:
                makeTransfer();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showInitialView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.MENU)
                .setText("Getting account info")
                .setIcon(R.drawable.ic_sync)
                .getView();

        this.slider = Slider.from(initialView).startIndeterminate();

        setContentView(initialView);
    }

    private void showNoProductsView() {
        View initialView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("No accounts registered yet")
                .setIcon(R.drawable.ic_help)
                .getView();

        setContentView(initialView);
    }

    private void showNoConnectivityView() {
        View errorView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Unable to make transfer")
                .setFootnote("Check your internet connection")
                .setIcon(R.drawable.ic_cloud_sad_150)
                .getView();

        setContentView(errorView);
    }

    private void createDebitProductCards() {
        new GetProductsTask(new FinishedTaskListener<List<Product>>() {
            @Override
            public void onResult(List<Product> products) {
                slider.hide();
                slider = null;

                if (products == null) {
                    showNoConnectivityView();
                } else if (products.isEmpty()) {
                    showNoProductsView();
                } else {
                    TransferOwnAccountsActivity.this.products = products;

                    for (Product product : products) {
                        cards.add(createScrollerCard(product, true /* is debit */));
                    }
                    updateCardScrollView(true /* is debit */);
                }
            }
        }).execute();
    }

    private void createCreditProductCards() {
        // All except the debit product just chosen
        Iterable<Product> availableProducts = Iterables.filter(products, new Predicate<Product>() {
            @Override
            public boolean apply(Product input) {
                return !StringUtils.equals(debitProduct.getProductNumber(), input.getProductNumber());
            }
        });

        products = Lists.newArrayList(availableProducts);

        for (Product product : products) {
            cards.add(createScrollerCard(product, false /* is NOT debit */));
        }

        updateCardScrollView(false /* is NOT debit */);
    }

    private void updateCardScrollView(final boolean isDebit) {
        CardScrollAdapter adapter = new TransferCardScrollAdapter();

        CardScrollView cardScrollView = new CardScrollView(this);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                am.playSoundEffect(Sounds.TAP);

                if (isDebit) {
                    debitProduct = products.get(position);
                    cards.clear();
                    createCreditProductCards();
                } else {
                    creditProduct = products.get(position);
                    showAmountView();
                }
            }
        });

        setContentView(cardScrollView);
    }

    private void showAmountView() {
        View amountView = getLayoutInflater().inflate(R.layout.transfer_amount, null);

        setTextViewText(amountView, R.id.from_number, this.debitProduct.getProductNumber());
        setTextViewText(amountView, R.id.to_number, this.creditProduct.getProductNumber());
        setTextViewText(amountView, R.id.transfer_currency, CURRENCY_SYMBOL);

        setContentView(amountView);
    }

    private CardBuilder createScrollerCard(Product product, boolean isDebit) {
        String alias = product.getProductAlias();
        String balance = product.getConsolidatedPositionBalance();
        String productNumber = product.getProductNumber();
        String accountDescription = product.getProductTypeDescription();
        int iconId = product.getProductIconId();
        String type = isDebit ? "Debit from:" : "Credit to:";

        return new CardBuilder(this, CardBuilder.Layout.COLUMNS_FIXED)
                .setText(accountDescription + "\n" + alias + "\n" + balance)
                .setFootnote(type)
                .setTimestamp(productNumber)
                .setIcon(iconId);
    }

    private class TransferCardScrollAdapter extends CardScrollAdapter {

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

    private void inflateMenu(int menuId) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(menuId, this.menu);
    }

    private GestureDetector createGestureDetector() {
        GestureDetector gestureDetector = new GestureDetector(this);
        gestureDetector.setBaseListener(new GestureDetector.BaseListener() {
            @Override
            public boolean onGesture(Gesture gesture) {
                if (gesture == Gesture.TAP) {
                    openOptionsMenu();
                }
                return false;
            }
        });
        gestureDetector.setScrollListener(new GestureDetector.ScrollListener() {
            @Override
            public boolean onScroll(float displacement, float delta, float velocity) {
                /*
                int oldAmount = Integer.parseInt(getTextViewText(R.id.transfer_amount));
                int newAmount = SwipeGestureUtils.calculateNewAmountFromSwipe(displacement, oldAmount);

                setTextViewText(R.id.transfer_amount, String.valueOf(newAmount));
*/
                return true;
            }
        });
        return gestureDetector;
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return gestureDetector != null && gestureDetector.onMotionEvent(event);
    }

    private void makeTransfer() {
        invalidateOptionsMenu();

        int amount = Integer.parseInt(getTextViewText(R.id.transfer_amount));
        showLastChanceView(amount);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                slider.hide();
                slider = null;
                
                showTransferSuccess();
            }
        }, TimeUnit.SECONDS.toMillis(3));
    }

    private void showLastChanceView(int amount) {
        View lastChanceView = new CardBuilder(this, CardBuilder.Layout.MENU)
                .setText(String.format("Transferring %s %s ...", CURRENCY_SYMBOL, amount))
                .setFootnote("swipe down to cancel")
                .getView();

        this.slider = Slider.from(lastChanceView).startIndeterminate();

        setContentView(lastChanceView);
    }

    private void showTransferSuccess() {
        View successView = new CardBuilder(this, CardBuilder.Layout.MENU)
                .setText("Transfer successful")
                .setIcon(R.drawable.ic_done_50)
                .getView();

        setContentView(successView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, TimeUnit.SECONDS.toMillis(1));
    }
}
