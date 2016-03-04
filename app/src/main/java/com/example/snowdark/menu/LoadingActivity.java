package com.example.snowdark.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;

/**
 * Created by SnowDark on 1/24/2016.
 */
public class LoadingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_loading);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken == null)
        {
            //
        }
        if (accessToken == null || accessToken.isExpired()) {
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //getToMainActivity();
                    gotToActivity(LoginActivity.class);
                }
            }, 2000);
        } else {
            gotToActivity(MainActivity.class);
        }
    }

    private void gotToActivity(Class<? extends Activity> activity) {
        Intent i = new Intent(this, activity);
        startActivity(i);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
