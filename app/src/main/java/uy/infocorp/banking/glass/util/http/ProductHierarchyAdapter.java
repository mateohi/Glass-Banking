package uy.infocorp.banking.glass.util.http;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

/**
 * Created by german on 16/11/2014.
 */
public class ProductHierarchyAdapter implements JsonDeserializer<Product> {

    private static final String TAG = ProductHierarchyAdapter.class.getSimpleName();

    /*
    * Another instance of Serializer to give an external context
    */
    private static final Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    private Map<String, String> productTypeMap = initializeProductTypeMap();

    private Map<String, String> initializeProductTypeMap() {
        productTypeMap = new HashMap<String, String>(10);
        productTypeMap.put("Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities",
                "uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.Account");
        productTypeMap.put("Infocorp.UIProcess.Entities.CreditLines.CreditLines.CreditLine, Infocorp.UIProcess.Entities",
                "uy.infocorp.banking.glass.integration.privateapi.common.dto.creditLines.CreditLine");
        productTypeMap.put("Infocorp.UIProcess.Entities.FixedTermDeposits.FixedTermDeposits.FixedTermDeposit, Infocorp.UIProcess.Entities",
                "uy.infocorp.banking.glass.integration.privateapi.common.dto.fixedDeposits.FixedTermDeposit");
        productTypeMap.put("Infocorp.UIProcess.Entities.CreditCards.CreditCards.CreditCard, Infocorp.UIProcess.Entities",
                "uy.infocorp.banking.glass.integration.privateapi.common.dto.creditCards.CreditCard");
        productTypeMap.put("Infocorp.UIProcess.Entities.Loans.Loans.Loan, Infocorp.UIProcess.Entities",
                "uy.infocorp.banking.glass.integration.privateapi.common.dto.loans.Loan");
        productTypeMap.put("Infocorp.UIProcess.Entities.Mortgages.Mortgages.Mortgage, Infocorp.UIProcess.Entities",
                "uy.infocorp.banking.glass.integration.privateapi.common.dto.mortgages.Mortgage");
        return productTypeMap;
    }

    private static final String CLASSNAME = "$type";

    /**
     * Deserealizes the Product to its corresponding subclass
     *
     * @param json
     * @param typeOfT
     * @param context
     * @return
     * @throws JsonParseException
     */
    @Override
    public Product deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        if (prim == null) {//json does not have the property type => Map super Class
            return GSON.fromJson(jsonObject, Product.class);
        }
        String clientSideMappedClassName = productTypeMap.get(prim.getAsString());

        Class<?> clazz = null;
        try {
            clazz = Class.forName(clientSideMappedClassName);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "RuntimeException: Unable to get latest transactions -" + e.getMessage());
            throw new JsonParseException(e.getMessage());
        }
        return context.deserialize(jsonObject, clazz);
    }

}
