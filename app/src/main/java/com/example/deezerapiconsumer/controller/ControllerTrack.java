package com.example.deezerapiconsumer.controller;

import android.content.Intent;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.view.View;

import com.example.deezerapiconsumer.entity.Track;
import com.example.deezerapiconsumer.util.Constants;
import com.example.deezerapiconsumer.util.HTTPSWeb;
import com.example.deezerapiconsumer.view.TrackActivity;
import com.google.gson.Gson;

public class ControllerTrack implements HTTPSWeb.OnResponseListener, View.OnClickListener {

    private TrackActivity activity;
    private HTTPSWeb web;
    private Gson gson;

    public ControllerTrack(TrackActivity activity) {
        this.activity = activity;
        init();
    }

    public void init(){
        web = new HTTPSWeb();
        web.setListener(this);
        gson = new Gson();

        activity.getTextTitle().setText((String)activity.getIntent().getExtras().get("title"));
        activity.getTextArtist().setText((String)activity.getIntent().getExtras().get("artist"));
        activity.getTextAlbum().setText((String)activity.getIntent().getExtras().get("album"));
        activity.getTextDuration().setText( ""+(long)activity.getIntent().getExtras().get("duration"));
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

    @Override
    public void onResponse(int callbackID, String response) {

    }
}
