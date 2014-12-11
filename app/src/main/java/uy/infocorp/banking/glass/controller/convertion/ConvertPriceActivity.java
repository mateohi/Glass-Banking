package uy.infocorp.banking.glass.controller.convertion;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.google.android.glass.content.Intents;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.Slider;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.domain.ocr.PriceExtractor;
import uy.infocorp.banking.glass.domain.ocr.TesseractManager;
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.format.PriceFormat;

public class ConvertPriceActivity extends Activity {

    private static final int TAKE_PICTURE_REQUEST = 1;
    private static final String TAG = ConvertPriceActivity.class.getSimpleName();

    private List<ExchangeRateDTO> exchangeRates;
    private Slider.Indeterminate slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        getExchangeRates();
    }

    private void getExchangeRates() {
        new GetExchangeRatesTask(new FinishedTaskListener<List<ExchangeRateDTO>>() {
            @Override
            public void onResult(List<ExchangeRateDTO> result) {
                if (result == null) {
                    showNoConnectivityView();
                } else {
                    takePicture();
                }
            }
        }).execute();
    }

    private void showNoConnectivityView() {
        View errorView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Unable to get Exchange Rates")
                .setFootnote("Check your internet connection")
                .setIcon(R.drawable.ic_warning)
                .getView();

        setContentView(errorView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.price_convertion, menu);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TAKE_PICTURE_REQUEST && resultCode == RESULT_OK) {
            final String thumbnailPath = data.getStringExtra(Intents.EXTRA_THUMBNAIL_FILE_PATH);
            //String picturePath = data.getStringExtra(Intents.EXTRA_PICTURE_FILE_PATH);

            showPreview(thumbnailPath);

            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    processPicture(thumbnailPath);
                }
            });
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void takePicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, TAKE_PICTURE_REQUEST);
    }

    private void showPreview(String thumbnailPath) {
        Bitmap preview = BitmapFactory.decodeFile(thumbnailPath);

        View initialView = new CardBuilder(this, CardBuilder.Layout.CAPTION)
                .setText("Analysing image ...")
                .addImage(preview)
                .getView();

        this.slider = Slider.from(initialView).startIndeterminate();

        setContentView(initialView);
    }

    private void processPicture(String path) {
        String result = TesseractManager.optimizeAndRecognizeText(path);

        List<String> symbols = Arrays.asList("$"); // FIXME dejar generico, usar exchangeRates
        Pair<String, Double> price = PriceExtractor.extractPrice(result, symbols);

        // Hide and discard slider
        this.slider.hide();
        this.slider = null;

        if (price == null) {
            showNoPriceView();
        } else {
            Pair<String, Double> convertedPrice = convertPrice(price);
            showPriceConvertion(price, convertedPrice);
        }
    }

    private Pair<String, Double> convertPrice(Pair<String, Double> price) {
        return Pair.create("U$S", price.second/23.0); //FIXME dejar generico
    }

    private void showPriceConvertion(Pair<String, Double> price, Pair<String, Double> convertedPrice) {
        View convertionView = new CardBuilder(this, CardBuilder.Layout.EMBED_INSIDE)
                .setEmbeddedLayout(R.layout.price_convertion)
                .setFootnote("UYU > USD") // FIXME sacar posta
                .getView();

        TextView fromView = (TextView) convertionView.findViewById(R.id.from_price);
        TextView convertedView = (TextView) convertionView.findViewById(R.id.converted_price);

        fromView.setText(price.first + PriceFormat.parseDefault(price.second));
        convertedView.setText(convertedPrice.first + PriceFormat.parseDefault(convertedPrice.second));

        setContentView(convertionView);
    }

    private void showNoPriceView() {
        View noPriceView = new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("No price was recognized")
                .setIcon(R.drawable.ic_help)
                .getView();

        setContentView(noPriceView);
    }

}
