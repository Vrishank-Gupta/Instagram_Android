package com.vrishankgupta.instaclone.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.vrishankgupta.instaclone.Home.HomeActivity;
import com.vrishankgupta.instaclone.Likes.LikesActivity;
import com.vrishankgupta.instaclone.Profile.ProfileActivity;
import com.vrishankgupta.instaclone.R;
import com.vrishankgupta.instaclone.Search.SearchActivity;
import com.vrishankgupta.instaclone.Share.ShareActivity;

/**
 * Created by vrishankgupta on 30/01/18.
 */

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx)
    {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }


    public static void enableNavigation(final Context context, BottomNavigationViewEx view)
    {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_house:
                        Intent intent1 = new Intent(context, HomeActivity.class); //act0
                        context.startActivity(intent1);
                        break;

                    case R.id.ic_search:
                        context.startActivity(new Intent(context, SearchActivity.class)); //act1
                        break;
                    case R.id.ic_circle:
                        context.startActivity(new Intent(context, ShareActivity.class)); //act2..
                        break;

                    case R.id.ic_alert:
                        context.startActivity(new Intent(context, LikesActivity.class));
                        break;

                    case R.id.ic_android:
                        context.startActivity(new Intent(context, ProfileActivity.class));
                        break;
                }



                return false;
            }
        });
    }


}
