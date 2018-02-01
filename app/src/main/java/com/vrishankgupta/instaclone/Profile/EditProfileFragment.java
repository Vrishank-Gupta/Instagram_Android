package com.vrishankgupta.instaclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.vrishankgupta.instaclone.R;
import com.vrishankgupta.instaclone.Utils.UniversalImageLoader;

/**
 * Created by vrishankgupta on 30/01/18.
 */

public class EditProfileFragment extends Fragment{
    private static final String TAG = "EditProfileFragment";
    private ImageView profilePhoto;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile,container,false);
        profilePhoto = view.findViewById(R.id.profile_photo);
        setProfileImage();

        // back arrow

        ImageView bacArrow = view.findViewById(R.id.backArrow);

        bacArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: back to profile act");
                getActivity().finish();
            }
        });


        return view;

    }



    private void setProfileImage()
    {
        Log.d(TAG, "setProfileImage: ");
        String imURL = "http://techbeat.com/wp-content/uploads/2013/07/Android-Security-Bug-Found-Hackers-Gain-System-Access.png";
        UniversalImageLoader.setImage(imURL,profilePhoto,null,"");
    }
}
