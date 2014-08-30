package uy.infocorp.banking.glass.integration.publicapi;

import android.graphics.Bitmap;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uy.infocorp.banking.glass.integration.publicapi.exchange.ExchangeRateClient;
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;
import uy.infocorp.banking.glass.integration.publicapi.image.ImageDownloadClient;
import uy.infocorp.banking.glass.integration.publicapi.image.dto.ImageDTO;
import uy.infocorp.banking.glass.util.graphics.BitmapUtils;

public class PublicApiService {

    public static List<ExchangeRateDTO> getExchangeRatesByAlpha3Code(String alpha3Code) {
        ExchangeRateDTO[] exchangeRates = ExchangeRateClient.instance().getExchangeRates();

        if (ArrayUtils.isEmpty(exchangeRates)) {
            return Collections.emptyList();
        }

        List<ExchangeRateDTO> filteredRates = new ArrayList<ExchangeRateDTO>();
        for (ExchangeRateDTO exchangeRate : exchangeRates) {
            String sourceAlpha3Code = exchangeRate.getSourceCurrencyDTO().getCurrencyAlpha3Code();
            String destinationAlpha3Code = exchangeRate.getDestinationCurrencyDTO().getCurrencyAlpha3Code();

            if (sourceAlpha3Code.equals(alpha3Code) && !sourceAlpha3Code.equals(destinationAlpha3Code)) {
                filteredRates.add(exchangeRate);
            }
        }

        return filteredRates;
    }

    public static Bitmap getImage(int imageId) {
        ImageDTO imageDTO = ImageDownloadClient.instance().getImage(imageId);
        String imageBase64 = imageDTO.getImagePicture();

        return BitmapUtils.base64ToBitmap(imageBase64);
    }
}
