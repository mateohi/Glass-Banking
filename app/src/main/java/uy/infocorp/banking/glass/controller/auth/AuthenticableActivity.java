package uy.infocorp.banking.glass.controller.auth;

import android.content.Intent;

import uy.infocorp.banking.glass.controller.common.ExtendedActivity;
import uy.infocorp.banking.glass.domain.authentication.Session;

public abstract class AuthenticableActivity extends ExtendedActivity {

    protected static final int AUTH_TOKEN_REQUEST = 0;
    protected String authToken;

    protected abstract void authenticationOk();

    protected abstract void authenticationError();

    protected void getAuthToken() {
        if (canGetAuthToken()) {
            authenticationOk();
        } else {
            startAuthenticationActivity();
        }
    }

    private boolean canGetAuthToken() {
        authToken = Session.getAuthToken();
        return authToken != null;
    }

    private void startAuthenticationActivity() {
        Intent authIntent = new Intent(this, AuthenticationActivity.class);
        authIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivityForResult(authIntent, AUTH_TOKEN_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == AUTH_TOKEN_REQUEST) {
            if (resultCode == RESULT_OK) {
                authToken = data.getStringExtra(AuthenticationActivity.AUTH_TOKEN_EXTRA);
                authenticationOk();
            } else {
                authenticationError();
            }
        }
    }
}
