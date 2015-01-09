package uy.infocorp.banking.glass.integration.privateapi.authentication;

import android.util.Log;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.Header;

import java.util.List;

import uy.infocorp.banking.glass.domain.authentication.Session;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityDeviceValidationResult;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityQuestionsAnswers;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityQuestionsAnswersList;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SignInInformation;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SignInResult;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.HttpUtils;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.Resources;

public class AuthenticationClient extends BaseClient {

    private static final String TAG = AuthenticationClient.class.getSimpleName();

    private static AuthenticationClient instance;
    private RestExecutionBuilder builder;

    private AuthenticationClient() {
        builder = RestExecutionBuilder.post(PrivateUrls.POST_SIGN_IN_URL);
    }

    public static AuthenticationClient instance() {
        if (instance == null) {
            instance = new AuthenticationClient();
        }
        return instance;
    }

    private SignInResult logOnFirstStep(String username, String password) {
        SignInInformation signInInformation = new SignInInformation(username, password);
        //initialize and execute post
        Pair<SignInResult, List<Header>> data = builder.appendObjectBody(signInInformation)
                .executeAndGetHeaders(SignInResult.class);

        SignInResult result = data.getLeft();
        List<Header> headers = data.getRight();

        //gets the header x_auth_token
        Header authToken = getAuthToken(headers);

        if (authToken != null) {
            result.setAuthToken(authToken.getValue());
        } else {
            Log.w(TAG, "No se pudo obtener el header X-Auth-Token al intentar loguearse");
        }

        return result;
    }

    private SecurityDeviceValidationResult validateSecurityDeviceSecondStep(SecurityQuestionsAnswers securityQuestionsAnswers,
                                                                            String signInAuthToken) {

        SecurityQuestionsAnswersList request = new SecurityQuestionsAnswersList();
        request.getSecurityQuestionsAnswers().add(securityQuestionsAnswers);

        //do post
        Header header = HttpUtils.buildTokenHeader(signInAuthToken);
        Pair<SecurityDeviceValidationResult, List<Header>> data = builder.post(PrivateUrls.POST_VALIDATE_SECURITY_DEVICE_URL)
                .appendObjectBody(request)
                .appendHeader(header)
                .executeAndGetHeaders(SecurityDeviceValidationResult.class);

        SecurityDeviceValidationResult result = data.getLeft();
        List<Header> headers = data.getRight();

        //gets the header corresponding to the x_auth_token
        Header authToken = getAuthToken(headers);

        if (authToken != null) {
            result.setAuthToken(authToken.getValue());
        } else {
            Log.w(TAG, "Unable to get X-Auth-Token header on validation");
        }

        return result;
    }

    private static Header getAuthToken(List<Header> headers) {
        for (Header header : headers) {
            if (header.getName().equals(HttpUtils.XAUTH_TOKEN_HEADER)) {
                return header;
            }
        }
        return null;
    }

    @Override
    protected Object getOffline() {
        return "test";
    }

    // Try to login and get the Authentication Token (executes both authentication steps)
    @Override
    protected Object getOnline() {
        //1- LogOn
        SignInResult signInResult = AuthenticationClient.instance().logOnFirstStep("prueba09", "1234");
        //ToDo: Validar success en respuesta a login (usuario bloqueado, password invalido, etc)
        String securityQuestionId = signInResult.getSignInInformation()
                .getSecurityQuestionsToAnswerForLoginDevice()
                .get(0)
                .getSecurityQuestionId();
        Integer secretQuestionId = Integer.parseInt(securityQuestionId);
        SecurityQuestionsAnswers questionAnswered = new SecurityQuestionsAnswers(secretQuestionId, "1111");

        //2- Security Device Validation
        SecurityDeviceValidationResult result = AuthenticationClient.instance()
                .validateSecurityDeviceSecondStep(questionAnswered, signInResult.getAuthToken());

        //ToDo: Validar success en respuesta a las preguntas de seguridad.
        return result.getAuthToken();
    }

    // Try to login and get the Authentication Token (executes both authentication steps)
    public String completeLogOn() {
        String authToken = (String) (this.execute());
        Session.setAuthToken(authToken);
        return authToken;
    }
}