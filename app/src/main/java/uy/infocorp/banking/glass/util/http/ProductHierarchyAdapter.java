package uy.infocorp.banking.glass.util.http;

import android.util.Log;

import com.google.common.collect.Maps;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;
import java.util.Map;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.Account;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.creditCards.CreditCard;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.creditLines.CreditLine;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.fixedDeposits.FixedTermDeposit;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.loans.Loan;

public class ProductHierarchyAdapter implements JsonDeserializer<Product> {

    private static final String TAG = ProductHierarchyAdapter.class.getSimpleName();
    private static final String CLASSNAME = "$type";

    private static Map<String, String> productTypeMap = Maps.newHashMap();

    static {
        productTypeMap.put("Infocorp.UIProcess.Entities.Accounts.Accounts.Account, Infocorp.UIProcess.Entities",
                Account.class.getName());
        productTypeMap.put("Infocorp.UIProcess.Entities.CreditLines.CreditLines.CreditLine, Infocorp.UIProcess.Entities",
                CreditLine.class.getName());
        productTypeMap.put("Infocorp.UIProcess.Entities.FixedTermDeposits.FixedTermDeposits.FixedTermDeposit, Infocorp.UIProcess.Entities",
                FixedTermDeposit.class.getName());
        productTypeMap.put("Infocorp.UIProcess.Entities.CreditCards.CreditCards.CreditCard, Infocorp.UIProcess.Entities",
                CreditCard.class.getName());
        productTypeMap.put("Infocorp.UIProcess.Entities.Loans.Loans.Loan, Infocorp.UIProcess.Entities",
                Loan.class.getName());
        productTypeMap.put("Infocorp.UIProcess.Entities.Mortgages.Mortgages.Mortgage, Infocorp.UIProcess.Entities",
                "uy.infocorp.banking.glass.integration.privateapi.common.dto.mortgages.Mortgage");
    }

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
        String clientSideMappedClassName = productTypeMap.get(prim.getAsString());

        Class<?> clazz = null;
        try {
            clazz = Class.forName(clientSideMappedClassName);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, e.getMessage(), e);
            throw new JsonParseException(e.getMessage());
        }
        return context.deserialize(jsonObject, clazz);
    }

}
