package com.msg91.axay.sendotp;

/**
 * @author akshay
 * @since 15/4/16
 */
public interface OtpVerificationListener {

    void onInitiationFailed(Exception exception);

    void onOtpVerificationSuccess(String mobileNumber, String response);

    void onOtpVerificationFailure(Exception exception);
}
