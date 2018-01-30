package com.vrishankgupta.instaclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.vrishankgupta.instaclone.R;
import com.vrishankgupta.instaclone.Utils.BottomNavigationViewHelper;

/**
 * Created by vrishankgupta on 30/01/18.
 */

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private Context mContext = ProfileActivity.this;
    private static final int ACTIVITY_NUM = 4;
    private ProgressBar mprogressBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: Started");
        mprogressBar = findViewById(R.id.profileProgressBar);
        mprogressBar.setVisibility(View.GONE);
        setupBottomNavigationView();
        setupToolbar();
    }
    private void setupToolbar()
    {
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to account settings. ");
                Intent intent = new Intent(mContext,AccountSettingsActivity.class);

                startActivity(intent);
            }
        });
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
