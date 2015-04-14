package uy.infocorp.banking.glass.controller.transfer.third;

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
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.controller.auth.AuthenticableActivity;
import uy.infocorp.banking.glass.controller.common.product.GetProductsTask;
import uy.infocorp.banking.glass.domain.gesture.SwipeGestureUtils;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.ThirdPartyAccount;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.ProductType;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.resources.Resources;

public class TransferThirdPartyAccountsActivity extends AuthenticableActivity {

    private static final String CURRENCY_SYMBOL = Resources.getString(R.string.alpha_symbol);
    private static final List<ProductType> VALID_TYPES = Arrays.asList(ProductType.currentAccount,
            ProductType.savingsAccount);

    private GestureDetector gestureDetector;

    private List<CardBuilder> cards = Lists.newArrayList();
    private List<Product> products = Lists.newArrayList();
    private List<ThirdPartyAccount> thirdPartyAccounts = Lists.newArrayList();

    private Product debitProduct;
    private ThirdPartyAccount creditThirdPartyAccount;
    private Slider.Indeterminate slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        getAuthToken();
    }

    @Override
    protected void authenticationOk() {
        showInitialView();
        createDebitProductCards();
    }

    @Override
    protected void authenticationError() {
        showAuthenticationErrorView();
        delayedFinish(3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.transfer, menu);
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

    private void showAuthenticationErrorView() {
        View errorView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Authentication error")
                .setFootnote("Check your pin")
                .setIcon(R.drawable.ic_warning_150)
                .getView();

        setContentView(errorView);
    }

    private void createDebitProductCards() {
        new GetProductsTask(new FinishedTaskListener<List<Product>>() {
            @Override
            public void onResult(List<Product> products) {
                slider.hide();

                if (products == null) {
                    showNoConnectivityView();
                    delayedFinish(3);
                } else if (products.isEmpty()) {
                    showNoProductsView();
                    delayedFinish(3);
                } else {
                    TransferThirdPartyAccountsActivity.this.products = products;

                    for (Product product : products) {
                        if (VALID_TYPES.contains(product.getProductType())) {
                            cards.add(createDebitProductCard(product));
                        }
                    }
                    updateCardScrollView(true /* is debit */);
                }
            }
        }).execute(this.authToken);
    }

    private void createCreditProductCards() {
        slider.show();

        new GetThirdPartyAccountsTask(new FinishedTaskListener<List<ThirdPartyAccount>>() {
            @Override
            public void onResult(List<ThirdPartyAccount> accounts) {
                slider.hide();
                slider = null;

                if (accounts == null) {
                    showNoConnectivityView();
                    delayedFinish(3);
                } else if (accounts.isEmpty()) {
                    showNoProductsView();
                    delayedFinish(3);
                } else {
                    TransferThirdPartyAccountsActivity.this.thirdPartyAccounts = accounts;
                    cards.clear();

                    for (ThirdPartyAccount account : accounts) {
                        cards.add(createCreditAccountCard(account));
                    }

                    updateCardScrollView(false /* is NOT debit */);
                }
            }
        }).execute(this.authToken);
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
                    createCreditProductCards();
                } else {
                    creditThirdPartyAccount = thirdPartyAccounts.get(position);
                    gestureDetector = createGestureDetector();
                    showAmountView();
                }
            }
        });

        setContentView(cardScrollView);
    }

    private void showAmountView() {
        View amountView = getLayoutInflater().inflate(R.layout.transfer_amount, null);

        setTextViewText(amountView, R.id.from_number, this.debitProduct.getProductNumber());
        setTextViewText(amountView, R.id.to_number, this.creditThirdPartyAccount.getThirdPartyAccountNumber());
        setTextViewText(amountView, R.id.transfer_currency, CURRENCY_SYMBOL);

        setContentView(amountView);
    }

    private CardBuilder createDebitProductCard(Product product) {
        String alias = product.getProductAlias();
        String balance = product.getConsolidatedPositionBalance();
        String productNumber = product.getProductNumber();
        String accountDescription = product.getProductTypeDescription();
        int iconId = product.getProductIconId();

        return new CardBuilder(this, CardBuilder.Layout.COLUMNS_FIXED)
                .setText(accountDescription + "\n" + alias + "\n" + balance)
                .setFootnote("Debit from:")
                .setTimestamp(productNumber)
                .setIcon(iconId);
    }

    private CardBuilder createCreditAccountCard(ThirdPartyAccount account) {
        String accountId = String.valueOf(account.getThirdPartyAccountId());
        String accountNumber = account.getThirdPartyAccountNumber();
        int iconId = account.getProductIconId();

        return new CardBuilder(this, CardBuilder.Layout.COLUMNS_FIXED)
                .setText(accountId)
                .setFootnote("Credit to:")
                .setTimestamp(accountNumber)
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

    private GestureDetector createGestureDetector() {
        GestureDetector gestureDetector = new GestureDetector(this);
        gestureDetector.setBaseListener(new GestureDetector.BaseListener() {
            @Override
            public boolean onGesture(Gesture gesture) {
                if (gesture == Gesture.TAP) {
                    AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
                    am.playSoundEffect(Sounds.TAP);

                    openOptionsMenu();
                }
                return false;
            }
        });
        gestureDetector.setScrollListener(new GestureDetector.ScrollListener() {
            @Override
            public boolean onScroll(float displacement, float delta, float velocity) {
                int oldAmount = Integer.parseInt(getTextViewText(R.id.transfer_amount));
                int newAmount = SwipeGestureUtils.calculateNewAmountFromSwipe(displacement, oldAmount);
                String amountToDisplay = SwipeGestureUtils.amountToDisplay(newAmount);

                setTextViewText(R.id.transfer_amount, amountToDisplay);

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

        final int amount = Integer.parseInt(getTextViewText(R.id.transfer_amount));
        showLastChanceView(amount, true /*can cancel*/);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                makeActualTransfer(amount);
            }
        }, TimeUnit.SECONDS.toMillis(3));
    }

    private void makeActualTransfer(int amount) {
        showLastChanceView(amount, false /*can NOT cancel*/);

        new TransferWithThirdPartyAccountTask(new FinishedTaskListener<Boolean>() {
            @Override
            public void onResult(Boolean successful) {
                slider.hide();
                slider = null;

                if (successful) {
                    showTransferSuccess();
                } else {
                    showTransferFailed();
                }

                delayedFinish();
            }
        }).execute(this.authToken, amount, debitProduct, creditThirdPartyAccount);
    }

    private void showLastChanceView(int amount, boolean canCancel) {
        View lastChanceView = new CardBuilder(this, CardBuilder.Layout.MENU)
                .setText(String.format("Transferring %s %s ...", CURRENCY_SYMBOL, amount))
                .setFootnote(canCancel ? "swipe down to cancel" : null)
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
    }

    private void showTransferFailed() {
        View successView = new CardBuilder(this, CardBuilder.Layout.MENU)
                .setText("Unable to complete transfer")
                .setIcon(R.drawable.ic_warning_150)
                .getView();

        setContentView(successView);
    }
}
