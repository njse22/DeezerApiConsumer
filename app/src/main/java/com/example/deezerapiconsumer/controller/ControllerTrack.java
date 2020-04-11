package com.example.deezerapiconsumer.controller;

import android.content.Intent;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.deezerapiconsumer.R;
import com.example.deezerapiconsumer.entity.Track;
import com.example.deezerapiconsumer.util.Constants;
import com.example.deezerapiconsumer.util.HTTPSWeb;
import com.example.deezerapiconsumer.view.TrackActivity;
import com.google.gson.Gson;

public class ControllerTrack implements View.OnClickListener {

    private TrackActivity activity;

    public ControllerTrack(TrackActivity activity) {
        this.activity = activity;
        init();
    }

    public void init(){
        activity.getTextTitle().setText((String)activity.getIntent().getExtras().get("title"));
        activity.getTextArtist().setText((String)activity.getIntent().getExtras().get("artist"));
        activity.getTextAlbum().setText("Album: "+ (String)activity.getIntent().getExtras().get("album"));
        long time = (long)activity.getIntent().getExtras().get("duration");
        long minutes = time/60;
        long seconds = time%60;
        activity.getTextDuration().setText(minutes +":"+ seconds);
        Glide.with(activity).load(
                (String)activity.getIntent().getExtras().get("picture")
        ).centerCrop().placeholder(R.drawable.ic_launcher_background).into(activity.getImageTrack());
        activity.getListenBtn().setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        new Thread(
                () ->{
                    Intent deezerApp = activity.getPackageManager().getLaunchIntentForPackage("deezer.android.app");
                    if(deezerApp != null){
                        deezerApp.setData(Uri.parse((String)activity.getIntent().getExtras().get("link")));
                        activity.startActivity(deezerApp);
                    }else{
                        Intent browser = new Intent(Intent.ACTION_VIEW);
                        browser.setData(Uri.parse((String)activity.getIntent().getExtras().get("link")));
                        activity.startActivity(browser);
                    }
                }
        ).start();
    }

}
