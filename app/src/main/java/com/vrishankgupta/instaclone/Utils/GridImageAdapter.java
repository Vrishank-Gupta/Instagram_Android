package com.vrishankgupta.instaclone.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.vrishankgupta.instaclone.R;

import java.util.ArrayList;

/**
 * Created by vrishankgupta on 01/02/18.
 */

public class GridImageAdapter extends ArrayAdapter<String> {
    private Context context;
    private LayoutInflater inflater;
    private int layoutResource;
    private String mAppend;
    private ArrayList<String> imgURLs;

    public GridImageAdapter(@NonNull Context context, int layoutResource, String mAppend, ArrayList<String> imgURLs) {
        super(context, layoutResource,imgURLs);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.layoutResource = layoutResource;
        this.mAppend = mAppend;
        this.imgURLs = imgURLs;
    }

    private static class ViewHolder{

        ImageView image;
        ProgressBar progressBar;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null)
        {
            convertView = inflater.inflate(layoutResource,parent,false);
            holder = new ViewHolder();
            holder.progressBar = convertView.findViewById(R.id.gridImageProgressBar);
            holder.image = convertView.findViewById(R.id.gridImageView);

            convertView.setTag(holder);


        }

        else holder = (ViewHolder) convertView.getTag();

        String imgURL = getItem(position);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(mAppend + imgURL, holder.image,new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if(holder.progressBar != null)
                {
                    holder.progressBar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                if(holder.progressBar != null)
                {
                    holder.progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                if(holder.progressBar != null)
                {
                    holder.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

                if(holder.progressBar != null)
                {
                    holder.progressBar.setVisibility(View.GONE);
                }
            }
        });

        return convertView;
    }
}
