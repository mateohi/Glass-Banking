package uy.infocorp.banking.glass.controller.account.movements;

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
import uy.infocorp.banking.glass.integration.privateapi.common.dto.movements.Movement;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.date.DateUtils;
import uy.infocorp.banking.glass.util.resources.Resources;
import uy.infocorp.banking.glass.util.serialization.EnumUtil;

public class LastMovementsActivity extends ExtendedActivity {

    private List<View> views = Lists.newArrayList();
    private Slider.Indeterminate slider;
    private String productBankIdentifier;
    private String sourceAccountNumber;
    private String sourceAccountAlias;
    private ProductType productType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        this.productBankIdentifier = intent.getStringExtra(ProductsBalanceActivity.PRODUCT_BANK_IDENTIFIER);
        this.sourceAccountAlias = intent.getStringExtra(ProductsBalanceActivity.PRODUCT_ALIAS);
        this.sourceAccountNumber = productBankIdentifier.split("\\|")[1];
        this.productType = EnumUtil.deserialize(ProductType.class).from(intent);

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
        View initialView = new CardBuilder(this, CardBuilder.Layout.MENU)
                .setText("Loading movements...")
                .setIcon(R.drawable.ic_sync)
                .getView();

        this.slider = Slider.from(initialView).startIndeterminate();

        setContentView(initialView);
    }

    private void showNoMovementsView() {
        View noMovementsView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("No movements found")
                .setIcon(R.drawable.ic_help)
                .getView();

        setContentView(noMovementsView);
    }

    private void showNoConnectivityView() {
        View errorView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Unable to get last movements")
                .setFootnote("Check your internet connection")
                .setIcon(R.drawable.ic_cloud_sad_150)
                .getView();

        setContentView(errorView);
    }

    private void createCards() {
        new GetLastMovementsTask(new FinishedTaskListener<List<Movement>>() {
            @Override
            public void onResult(List<Movement> movements) {
                slider.hide();
                slider = null;

                if (movements == null) {
                    showNoConnectivityView();
                } else if (movements.isEmpty()) {
                    showNoMovementsView();
                } else {

                    for (Movement movement : movements) {
                        views.add(createView(movement));
                    }
                    updateCardScrollView();
                }
            }
        }).execute(this.productBankIdentifier, this.productType);
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
            }
        });

        setContentView(cardScrollView);
    }

    private View createView(Movement movement) {
        String productCode = (String) movement.getExtendedProperties().get("productCode");
        String movementDate = DateUtils.simpleMonthDateFormat(movement.getMovementDate());
        String amount = Resources.getString(R.string.alpha_symbol) + " " + movement.getAmount().toString();
        String observations = (String) movement.getExtendedProperties().get("observations");

        View convertView = getLayoutInflater().inflate(R.layout.transaction_history_item, null);

        setTextViewText(convertView, R.id.timestamp, movementDate);
        setTextViewText(convertView, R.id.text_view_top_left_title, sourceAccountAlias);
        setTextViewText(convertView, R.id.text_view_bottom_left_title, productCode);
        setTextViewText(convertView, R.id.text_view_right_title, amount);
        setTextViewText(convertView, R.id.text_view_top_right_title, observations);

        return convertView;
    }

    private int getIconFromMovement(Movement movement) {
        // TODO Agarrar el tipo de movimiento y mostrar diferentes iconos
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
