package com.axay.sendotp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.msg91.axay.sendotp.OtpVerificationListener;
import com.msg91.axay.sendotp.SendOtpActivity;

public class MainActivity extends AppCompatActivity implements OtpVerificationListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SendOtpActivity.start(this);
    }

    @Override
    public void onOtpVerificationSuccess(String mobileNumber, String response) {
        Log.i(TAG, mobileNumber + response);
    }

    @Override
    public void onOtpVerificationFailure(Exception exception) {
        Log.i(TAG, exception.getMessage());
    }

    @Override
    public void onInitiationFailed(Exception exception) {
        Log.i(TAG, exception.getMessage());
    }
}
