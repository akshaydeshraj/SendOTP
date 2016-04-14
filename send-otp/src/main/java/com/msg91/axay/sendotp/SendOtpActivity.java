package com.msg91.axay.sendotp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author akshay
 * @since 12/4/16
 */
public class SendOtpActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, SendOtpActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendotp);
    }
}
