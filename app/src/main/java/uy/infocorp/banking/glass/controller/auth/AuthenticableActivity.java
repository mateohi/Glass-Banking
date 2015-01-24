package uy.infocorp.banking.glass.controller.auth;

import android.content.Intent;

import uy.infocorp.banking.glass.controller.common.ExtendedActivity;
import uy.infocorp.banking.glass.domain.authentication.Session;

public abstract class AuthenticableActivity extends ExtendedActivity {

    protected static final int AUTH_TOKEN_REQUEST = 1990;
    protected String authToken;

    protected abstract void startPostAuthenticationActivity();

    protected void getAuthToken() {
        if (canGetAuthToken()) {
            startPostAuthenticationActivity();
        } else {
            startAuthenticationActivity();
        }
    }

    protected void authenticationOk(Intent data) {
        authToken = data.getStringExtra(AuthenticationActivity.AUTH_TOKEN_EXTRA);
        startPostAuthenticationActivity();
    }

    private boolean canGetAuthToken() {
        authToken = Session.getAuthToken();
        return authToken != null;
    }

    private void startAuthenticationActivity() {
        Intent authIntent = new Intent(this, AuthenticationActivity.class);
        startActivityForResult(authIntent, AUTH_TOKEN_REQUEST);
    }
}
