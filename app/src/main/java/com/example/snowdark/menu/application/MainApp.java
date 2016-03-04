package com.example.snowdark.menu.application;

import android.app.Application;
import android.util.Log;


/**
 * Created by SnowDark on 1/26/2016.
 */
public class MainApp extends Application {



    public static MainApp instance()
    {
        return instance;
    }

    private static MainApp instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MAINAPP", "onCreate");
        instance = this;
    }
}
