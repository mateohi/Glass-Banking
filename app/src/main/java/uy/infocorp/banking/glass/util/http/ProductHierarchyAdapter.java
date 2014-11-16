package uy.infocorp.banking.glass.util.http;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

/**
 * Created by german on 16/11/2014.
 */
public class ProductHierarchyAdapter implements JsonDeserializer<Product> {

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
        String clientSideMappedClassName = productTypeMap.get(prim.getAsString());

        Class<?> clazz = null;
        try {
            clazz = Class.forName(clientSideMappedClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new JsonParseException(e.getMessage());
        }
        return context.deserialize(jsonObject, clazz);
    }

}
