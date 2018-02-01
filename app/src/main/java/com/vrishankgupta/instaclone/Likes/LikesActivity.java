package com.vrishankgupta.instaclone.Likes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.vrishankgupta.instaclone.R;
import com.vrishankgupta.instaclone.Utils.BottomNavigationViewHelper;

/**
 * Created by vrishankgupta on 30/01/18.
 */

public class LikesActivity extends AppCompatActivity {
    private static final String TAG = "LikesActivity";
    private Context mContext = LikesActivity.this;
    private static final int ACTIVITY_NUM = 3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(TAG, "onCreate: Started");
//        setupBottomNavigationView();
    }

    /**
     * Bottom navigation view
     **/

    private void setupBottomNavigationView()
    {
        Log.d(TAG, "setupBottomNavigationView: setting up botNavView");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
