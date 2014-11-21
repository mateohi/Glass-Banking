package uy.infocorp.banking.glass.integration.privateapi.products;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.integration.Constants;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.util.http.HttpUtils;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;

public class ProductsClient {

    private static final String TAG = ProductsClient.class.getSimpleName();

    private static ProductsClient instance;
    private RestExecutionBuilder builder;

    private ProductsClient() {
        builder = RestExecutionBuilder.get(PrivateUrls.GET_CONSOLIDATED_POSITION_URL);
    }

    public static ProductsClient instance() {
        if (instance == null) {
            instance = new ProductsClient();
        }
        return instance;
    }

    public List<Product> getConsolidatedPosition(String authToken) throws UnsupportedEncodingException {
        if (Constants.OFFLINE_MODE) {//test
            String data = test();
            Product[] productList = HttpUtils.typeFromStringData(data, Product[].class);
            return Arrays.asList(productList);
        }

        Header tokenHeader = new BasicHeader(Constants.X_AUTH_TOKEN_HEADER_NAME, authToken);
        Product[] productList = builder.appendHeader(tokenHeader).execute(Product[].class);

        return Arrays.asList(productList);
    }

    public String test() {
        return "[{" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": 527422876," +
                "    \"productBankIdentifier\": \"1|003106853222|DDA\"," +
                "    \"accountCountableBalance\": 4583.73," +
                "    \"productNumber\": \"003106853222\"," +
                "    \"accountAvailableBalance\": 5095.38," +
                "    \"productAlias\": \"Cuenta familiar\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"currentAccount\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": true," +
                "        \"eStatementPending\": false," +
                "        \"achFee\": 3.0," +
                "        \"realAvailableBalance\": 4583.73" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": -141409750," +
                "    \"productBankIdentifier\": \"2|004005450018|SVT\"," +
                "    \"accountCountableBalance\": 6590.77," +
                "    \"productNumber\": \"004005450018\"," +
                "    \"accountAvailableBalance\": 6590.77," +
                "    \"productAlias\": \"Ahorros Pagos222\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"savingsAccount\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": true," +
                "        \"eStatementPending\": false," +
                "        \"achFee\": 3.0," +
                "        \"realAvailableBalance\": 6590.77" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": -1418108398," +
                "    \"productBankIdentifier\": \"1|003107442803|DDA\"," +
                "    \"accountCountableBalance\": 6351.77," +
                "    \"productNumber\": \"003107442803\"," +
                "    \"accountAvailableBalance\": 6351.77," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"currentAccount\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": false," +
                "        \"eStatementPending\": false," +
                "        \"achFee\": 3.0," +
                "        \"realAvailableBalance\": 6351.77" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": 1168639694," +
                "    \"productBankIdentifier\": \"1|003150000067|DDA\"," +
                "    \"accountCountableBalance\": 110400.25," +
                "    \"productNumber\": \"003150000067\"," +
                "    \"accountAvailableBalance\": 112900.25," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"currentAccount\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": false," +
                "        \"eStatementPending\": false," +
                "        \"achFee\": 3.0," +
                "        \"realAvailableBalance\": 110400.25" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": -447082747," +
                "    \"productBankIdentifier\": \"1|003150000075|DDA\"," +
                "    \"accountCountableBalance\": 7661.81," +
                "    \"productNumber\": \"003150000075\"," +
                "    \"accountAvailableBalance\": 7661.81," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"currentAccount\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": false," +
                "        \"eStatementPending\": false," +
                "        \"achFee\": 3.0," +
                "        \"realAvailableBalance\": 7661.81" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": -1961023109," +
                "    \"productBankIdentifier\": \"2|004150000055|SVT\"," +
                "    \"accountCountableBalance\": 4190.29," +
                "    \"productNumber\": \"004150000055\"," +
                "    \"accountAvailableBalance\": 4190.29," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"savingsAccount\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": false," +
                "        \"eStatementPending\": false," +
                "        \"achFee\": 3.0," +
                "        \"realAvailableBalance\": 4190.29" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": 1575198918," +
                "    \"productBankIdentifier\": \"2|004150000063|SVT\"," +
                "    \"accountCountableBalance\": 2025.00," +
                "    \"productNumber\": \"004150000063\"," +
                "    \"accountAvailableBalance\": 2025.00," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"savingsAccount\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": false," +
                "        \"eStatementPending\": false," +
                "        \"achFee\": 3.0," +
                "        \"realAvailableBalance\": 2025.00" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": -719013317," +
                "    \"productBankIdentifier\": \"5|006003700583|IRA\"," +
                "    \"accountCountableBalance\": 1000.00," +
                "    \"productNumber\": \"006003700583\"," +
                "    \"accountAvailableBalance\": 1000.00," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"investment\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": false," +
                "        \"eStatementPending\": false," +
                "        \"startDate\": \"2014-05-01T03:00:00Z\"," +
                "        \"expirationDate\": \"2015-05-01T03:00:00Z\"," +
                "        \"interestPaidToDate\": 0.00," +
                "        \"cumulateInterest\": 0.0000" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": -1998077324," +
                "    \"productBankIdentifier\": \"5|006003700605|IRA\"," +
                "    \"accountCountableBalance\": 1000.00," +
                "    \"productNumber\": \"006003700605\"," +
                "    \"accountAvailableBalance\": 1000.00," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"investment\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": false," +
                "        \"eStatementPending\": false," +
                "        \"startDate\": \"2014-05-01T03:00:00Z\"," +
                "        \"expirationDate\": \"2015-05-01T03:00:00Z\"," +
                "        \"interestPaidToDate\": 0.00," +
                "        \"cumulateInterest\": 0.0000" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": -706635823," +
                "    \"productBankIdentifier\": \"5|006003700613|IRA\"," +
                "    \"accountCountableBalance\": 1000.00," +
                "    \"productNumber\": \"006003700613\"," +
                "    \"accountAvailableBalance\": 1000.00," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"investment\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": false," +
                "        \"eStatementPending\": false," +
                "        \"startDate\": \"2014-05-01T03:00:00Z\"," +
                "        \"expirationDate\": \"2015-05-01T03:00:00Z\"," +
                "        \"interestPaidToDate\": 0.00," +
                "        \"cumulateInterest\": 0.0000" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": -544498426," +
                "    \"productBankIdentifier\": \"5|006003700621|IRA\"," +
                "    \"accountCountableBalance\": 1000.00," +
                "    \"productNumber\": \"006003700621\"," +
                "    \"accountAvailableBalance\": 1000.00," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"investment\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": false," +
                "        \"eStatementPending\": false," +
                "        \"startDate\": \"2014-05-01T03:00:00Z\"," +
                "        \"expirationDate\": \"2015-05-01T03:00:00Z\"," +
                "        \"interestPaidToDate\": 0.00," +
                "        \"cumulateInterest\": 0.0000" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities\"," +
                "    \"accountBank\": {" +
                "        \"bankId\": 0" +
                "    }," +
                "    \"productId\": -1000255929," +
                "    \"productBankIdentifier\": \"5|006003700648|IRA\"," +
                "    \"accountCountableBalance\": 1000.00," +
                "    \"productNumber\": \"006003700648\"," +
                "    \"accountAvailableBalance\": 1000.00," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"accountBalance24Hrs\": 0.0," +
                "    \"productType\": \"investment\"," +
                "    \"accountBalance48Hrs\": 0.0," +
                "    \"accountBalance48MoreHrs\": 0.0," +
                "    \"monthlyAverageBalance\": 0.0," +
                "    \"clientId\": 0," +
                "    \"pendingChecks\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"checksToReleaseToday\": 0," +
                "    \"checksToReleaseTomorrow\": 0," +
                "    \"cancelledChecks\": 0," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": false," +
                "        \"eStatementPending\": false," +
                "        \"startDate\": \"2014-05-01T03:00:00Z\"," +
                "        \"expirationDate\": \"2015-05-01T03:00:00Z\"," +
                "        \"interestPaidToDate\": 0.00," +
                "        \"cumulateInterest\": 0.0000" +
                "    }," +
                "    \"certifiedChecks\": 0," +
                "    \"canTransact\": false," +
                "    \"rejectedChecks\": 0," +
                "    \"subsidiaryId\": 0," +
                "    \"blockedAmount\": 0.0," +
                "    \"movementsOfTheMonth\": 0," +
                "    \"backendId\": 0," +
                "    \"checksDrawn\": 0," +
                "    \"overdrafts\": 0.0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.CreditLines.CreditLines.CreditLine, Infocorp.UIProcess.Entities\"," +
                "    \"productId\": -1624155018," +
                "    \"productBankIdentifier\": \"3|003300010554|RCS\"," +
                "    \"availableAmount\": 511.65," +
                "    \"productNumber\": \"003300010554\"," +
                "    \"totalAmount\": 1129.00," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"usedAmount\": -617.35," +
                "    \"productType\": \"creditLine\"," +
                "    \"clientId\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"extendedProperties\": {" +
                "        \"availableBalance\": 5095.38," +
                "        \"availableBalanceBDC\": 4583.73," +
                "        \"currentBalance\": 4583.73," +
                "        \"loanReserveInformation_lastPaymentAmount\": 617.35," +
                "        \"loanReserveInformation_lastDatePayment\": \"2012-12-18T02:00:00Z\"," +
                "        \"loanReserveInformation_lastReserveDate\": \"2012-12-18T02:00:00Z\"" +
                "    }," +
                "    \"canTransact\": false," +
                "    \"subsidiaryId\": 0," +
                "    \"backendId\": 0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.CreditLines.CreditLines.CreditLine, Infocorp.UIProcess.Entities\"," +
                "    \"productId\": -2091969790," +
                "    \"productBankIdentifier\": \"3|003350000134|RCS\"," +
                "    \"availableAmount\": 2500.00," +
                "    \"productNumber\": \"003350000134\"," +
                "    \"totalAmount\": 4000.00," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"usedAmount\": -1500.00," +
                "    \"productType\": \"creditLine\"," +
                "    \"clientId\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"extendedProperties\": {" +
                "        \"availableBalance\": 112900.25," +
                "        \"availableBalanceBDC\": 110400.25," +
                "        \"currentBalance\": 110400.25," +
                "        \"loanReserveInformation_lastPaymentAmount\": 4000.00" +
                "    }," +
                "    \"canTransact\": false," +
                "    \"subsidiaryId\": 0," +
                "    \"backendId\": 0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.FixedTermDeposits.FixedTermDeposits.FixedTermDeposit, Infocorp.UIProcess.Entities\"," +
                "    \"originalAmount\": 7000.00," +
                "    \"rate\": 0.0," +
                "    \"productId\": -510076707," +
                "    \"productBankIdentifier\": \"4|005004873639|CDS\"," +
                "    \"productNumber\": \"005004873639\"," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"currentBalance\": 0.0," +
                "    \"productType\": \"fixedTermDeposit\"," +
                "    \"clientId\": 0," +
                "    \"interestEarned\": 0.0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"interestPaid\": 0.0," +
                "    \"extendedProperties\": {" +
                "        \"company\": \"0004\"," +
                "        \"longFixedDepositAccountNumber\": \"00000-005004873639--\"," +
                "        \"nextInterest\": 7.00," +
                "        \"originalAmount\": 7000.00," +
                "        \"paymentDate\": \"2014-05-06T03:00:00Z\"," +
                "        \"start\": \"2014-05-01T03:00:00Z\"," +
                "        \"term\": \"365\"" +
                "    }," +
                "    \"expirationDate\": \"2015-05-01T03:00:00Z\"," +
                "    \"canTransact\": false," +
                "    \"subsidiaryId\": 0," +
                "    \"backendId\": 0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.CreditCards.CreditCards.CreditCard, Infocorp.UIProcess.Entities\"," +
                "    \"creditCardId\": 0," +
                "    \"dollarBalance\": 1585.67," +
                "    \"dollarCreditLimit\": 0.0," +
                "    \"dueDate\": \"2014-10-28T02:00:00Z\"," +
                "    \"fatherCreditCardId\": 0," +
                "    \"hasInternationalCurrency\": false," +
                "    \"localBalance\": 0.0," +
                "    \"localCreditLimit\": 10000.00," +
                "    \"productId\": 77485587," +
                "    \"productBankIdentifier\": \"6|00040917400000069050||5521960700018116\"," +
                "    \"productNumber\": \"5521960700018116\"," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"productType\": \"creditCard\"," +
                "    \"clientId\": 0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"extendedProperties\": {" +
                "        \"eStatementActive\": false," +
                "        \"eStatementPending\": false," +
                "        \"dueBalance\": 8404.71," +
                "        \"associatedAccountNumber\": \"00040917400000069050\"," +
                "        \"creditCardSubProduct_CreditCardDescription\": \"MASTERCARD PLATINO\"," +
                "        \"creditCardSubProduct_CreditCardType\": \"MASTERCARD\"," +
                "        \"creditCardSubProduct_SubProductId\": \"0206\"," +
                "        \"paymentDeadline\": \"2014-10-28T02:00:00Z\"," +
                "        \"minimumPayment\": 0.00" +
                "    }," +
                "    \"canTransact\": true," +
                "    \"subsidiaryId\": 0," +
                "    \"backendId\": 0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Loans.Loans.Loan, Infocorp.UIProcess.Entities\"," +
                "    \"originalAmount\": 29000.00," +
                "    \"payoffBalance\": 0.0," +
                "    \"productId\": -1456335163," +
                "    \"productBankIdentifier\": \"7|008008698210|ILS\"," +
                "    \"currentRate\": 0.0," +
                "    \"productNumber\": \"008008698210\"," +
                "    \"term\": 0," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"paidFees\": 0," +
                "    \"productType\": \"loan\"," +
                "    \"currentBalance\": 17707.24," +
                "    \"nextFee\": {" +
                "        \"feeNumber\": 0," +
                "        \"principalAmount\": 423.51," +
                "        \"dueDate\": \"2014-11-21T02:00:00Z\"," +
                "        \"interestAmount\": 0.0," +
                "        \"overdueAmount\": 0.0," +
                "        \"othersAmount\": 0.0," +
                "        \"capitalBalance\": 0.0" +
                "    }," +
                "    \"clientId\": 0," +
                "    \"prepaymentAmount\": 0.0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"feesDue\": 0," +
                "    \"feesDuePrincipalAmount\": 17707.24," +
                "    \"extendedProperties\": {" +
                "        \"lastPaymentDate\": \"2014-10-21T02:00:00Z\"," +
                "        \"interestPaidYearToDate\": 3437.94," +
                "        \"interestRate\": 5.9900," +
                "        \"issueDate\": \"2011-09-21T03:00:00Z\"," +
                "        \"lastYearInterest\": 437.20," +
                "        \"maturityDate\": \"2018-09-21T03:00:00Z\"," +
                "        \"term\": \"084\"" +
                "    }," +
                "    \"feesDueInterestAmount\": 0.0," +
                "    \"canTransact\": false," +
                "    \"feesDueOverdueAmount\": 0.0," +
                "    \"subsidiaryId\": 0," +
                "    \"feesDueOthersAmount\": 0.0," +
                "    \"overdueDays\": 0," +
                "    \"backendId\": 0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Loans.Loans.Loan, Infocorp.UIProcess.Entities\"," +
                "    \"originalAmount\": 48250.00," +
                "    \"payoffBalance\": 0.0," +
                "    \"productId\": 1477866124," +
                "    \"productBankIdentifier\": \"7|008008980617|ILS\"," +
                "    \"currentRate\": 0.0," +
                "    \"productNumber\": \"008008980617\"," +
                "    \"term\": 0," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"paidFees\": 0," +
                "    \"productType\": \"loan\"," +
                "    \"currentBalance\": 45220.59," +
                "    \"nextFee\": {" +
                "        \"feeNumber\": 0," +
                "        \"principalAmount\": 881.75," +
                "        \"dueDate\": \"2014-10-28T02:00:00Z\"," +
                "        \"interestAmount\": 0.0," +
                "        \"overdueAmount\": 0.0," +
                "        \"othersAmount\": 0.0," +
                "        \"capitalBalance\": 0.0" +
                "    }," +
                "    \"clientId\": 0," +
                "    \"prepaymentAmount\": 0.0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"feesDue\": 0," +
                "    \"feesDuePrincipalAmount\": 45220.59," +
                "    \"extendedProperties\": {" +
                "        \"lastPaymentDate\": \"2014-09-29T03:00:00Z\"," +
                "        \"interestPaidYearToDate\": 1103.72," +
                "        \"interestRate\": 6.9500," +
                "        \"issueDate\": \"2014-04-28T03:00:00Z\"," +
                "        \"lastYearInterest\": 0.00," +
                "        \"maturityDate\": \"2019-10-28T02:00:00Z\"," +
                "        \"term\": \"066\"" +
                "    }," +
                "    \"feesDueInterestAmount\": 0.0," +
                "    \"canTransact\": false," +
                "    \"feesDueOverdueAmount\": 0.0," +
                "    \"subsidiaryId\": 0," +
                "    \"feesDueOthersAmount\": 0.0," +
                "    \"overdueDays\": 0," +
                "    \"backendId\": 0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Loans.Loans.Loan, Infocorp.UIProcess.Entities\"," +
                "    \"originalAmount\": 0.0," +
                "    \"payoffBalance\": 0.0," +
                "    \"productId\": -1105754500," +
                "    \"productBankIdentifier\": \"8|0000010047042|MOR\"," +
                "    \"currentRate\": 0.0," +
                "    \"productNumber\": \"0000010047042\"," +
                "    \"term\": 0," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"paidFees\": 0," +
                "    \"productType\": \"undefined\"," +
                "    \"currentBalance\": 151481.93," +
                "    \"nextFee\": {" +
                "        \"feeNumber\": 0," +
                "        \"principalAmount\": 1251.63," +
                "        \"dueDate\": \"2013-03-01T02:00:00Z\"," +
                "        \"interestAmount\": 0.0," +
                "        \"overdueAmount\": 0.0," +
                "        \"othersAmount\": 0.0," +
                "        \"capitalBalance\": 0.0" +
                "    }," +
                "    \"clientId\": 0," +
                "    \"prepaymentAmount\": 0.0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"feesDue\": 0," +
                "    \"feesDuePrincipalAmount\": 151481.93," +
                "    \"extendedProperties\": {}," +
                "    \"feesDueInterestAmount\": 0.0," +
                "    \"canTransact\": false," +
                "    \"feesDueOverdueAmount\": 0.0," +
                "    \"subsidiaryId\": 0," +
                "    \"feesDueOthersAmount\": 0.0," +
                "    \"overdueDays\": 0," +
                "    \"backendId\": 0" +
                "}, {" +
                "    \"$type\": \"Infocorp.UIProcess.Entities.Loans.Loans.Loan, Infocorp.UIProcess.Entities\"," +
                "    \"originalAmount\": 0.0," +
                "    \"payoffBalance\": 0.0," +
                "    \"productId\": -1105718497," +
                "    \"productBankIdentifier\": \"8|0000010047140|MOR\"," +
                "    \"currentRate\": 0.0," +
                "    \"productNumber\": \"0000010047140\"," +
                "    \"term\": 0," +
                "    \"productAlias\": \"Nombre de cuenta\"," +
                "    \"paidFees\": 0," +
                "    \"productType\": \"undefined\"," +
                "    \"currentBalance\": 145.00," +
                "    \"nextFee\": {" +
                "        \"feeNumber\": 0," +
                "        \"principalAmount\": 154.36," +
                "        \"dueDate\": \"2008-04-01T03:00:00Z\"," +
                "        \"interestAmount\": 0.0," +
                "        \"overdueAmount\": 0.0," +
                "        \"othersAmount\": 0.0," +
                "        \"capitalBalance\": 0.0" +
                "    }," +
                "    \"clientId\": 0," +
                "    \"prepaymentAmount\": 0.0," +
                "    \"currency\": {" +
                "        \"currencyId\": \"840\"" +
                "    }," +
                "    \"feesDue\": 0," +
                "    \"feesDuePrincipalAmount\": 145.00," +
                "    \"extendedProperties\": {}," +
                "    \"feesDueInterestAmount\": 0.0," +
                "    \"canTransact\": false," +
                "    \"feesDueOverdueAmount\": 0.0," +
                "    \"subsidiaryId\": 0," +
                "    \"feesDueOthersAmount\": 0.0," +
                "    \"overdueDays\": 0," +
                "    \"backendId\": 0" +
                "}]";
    }

}
