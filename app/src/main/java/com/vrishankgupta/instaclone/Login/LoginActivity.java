package com.vrishankgupta.instaclone.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vrishankgupta.instaclone.R;

/**
 * Created by vrishankgupta on 01/02/18.
 */

public class LoginActivity  extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
