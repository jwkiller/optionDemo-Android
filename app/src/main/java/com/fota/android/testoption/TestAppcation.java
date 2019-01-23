package com.fota.android.testoption;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.fota.android.commonlib.utils.SharedPreferencesUtil;
import com.fota.android.commonlib.utils.ToastUitl;
import com.fota.option.OptionConfig;
import com.fota.option.OptionManager;
import com.fota.option.OptionSdkActivity;

public class TestAppcation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesUtil.init(this);
        OptionConfig config = getOptionConfig();
        OptionManager.init("2", config, this);
        OptionManager.userId = "2508713162866033664";
        OptionManager.token = "me5a1nvy6m";

    }

    @NonNull
    private OptionConfig getOptionConfig() {
        OptionConfig config = new OptionConfig();
        config.setDevelopment(true);

//        config.setHttpHost("https://api-test.fota.com/mapi/");
//        config.setSocketHost("wss://api-test.fota.com/mapi/websocket");
        config.setPageChangeListener(new OptionConfig.PageChangeListener() {

            @Override
            public void gotoDepositPage(Context context) {
                Intent intent = new Intent(context, DepositPageActivity.class);
                startActivity(intent);
            }

            @Override
            public void gotoLoginPage(Context context) {
                Intent intent = new Intent(context, LoginPageActivity.class);
                startActivity(intent);
            }

            @Override
            public void gotoAllOrderPage(Context context) {
                Intent intent = new Intent(context, AllOrderPageActivity.class);
                startActivity(intent);
            }
        });
        return config;
    }

}
