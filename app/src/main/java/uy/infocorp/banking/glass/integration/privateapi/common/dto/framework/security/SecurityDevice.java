package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.security;

public enum SecurityDevice {
    undefined,
    pin,
    securityQuestion,
    otp,
    cardCode,
    digitalCertificate,
    smsToken,
    loginUserImage,
    secretQuestion
}