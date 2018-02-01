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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.vrishankgupta.instaclone.R;
import com.vrishankgupta.instaclone.Utils.BottomNavigationViewHelper;
import com.vrishankgupta.instaclone.Utils.GridImageAdapter;
import com.vrishankgupta.instaclone.Utils.UniversalImageLoader;

import java.util.ArrayList;

/**
 * Created by vrishankgupta on 30/01/18.
 */

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private Context mContext = ProfileActivity.this;
    private static final int ACTIVITY_NUM = 4;
    private ProgressBar mprogressBar;
    private ImageView profilePhoto;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: Started");

        setupBottomNavigationView();
        setupToolbar();
        setupActivityWidgets();
        setProfilePhoto();
        temGridSetup();
    }

    public void setImageGrid(ArrayList<String> imgURLs)
    {
        GridView gridView = findViewById(R.id.gridView);
        GridImageAdapter adapter = new GridImageAdapter(mContext,R.layout.layout_grid_imageview,"",imgURLs);
        gridView.setAdapter(adapter);
    }

    private void temGridSetup()
    {
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg");
        imgURLs.add("http://i.imgur.com/EwZRpvQ.jpg");
        imgURLs.add("http://i.imgur.com/JTb2pXP.jpg");
        imgURLs.add("https://i.redd.it/59kjlxxf720z.jpg");
        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
        imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
        imgURLs.add("http://i.imgur.com/j4AfH6P.jpg");
        imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
        imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");

        setImageGrid(imgURLs);

    }

    private void setProfilePhoto()
    {
        String imgURL = "http://techbeat.com/wp-content/uploads/2013/07/Android-Security-Bug-Found-Hackers-Gain-System-Access.png";
        UniversalImageLoader.setImage(imgURL,profilePhoto,mprogressBar,"");
    }

    private void setupActivityWidgets()
    {
        mprogressBar = findViewById(R.id.profileProgressBar);
        mprogressBar.setVisibility(View.GONE);
        profilePhoto = findViewById(R.id.profile_photo);
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
