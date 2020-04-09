package com.example.deezerapiconsumer.controller;

import com.example.deezerapiconsumer.entity.Playlist;
import com.example.deezerapiconsumer.entity.Track;
import com.example.deezerapiconsumer.util.Constants;
import com.example.deezerapiconsumer.util.HTTPSWeb;
import com.example.deezerapiconsumer.view.PlaylistActivity;
import com.google.gson.Gson;

public class AuxControllerPlaylist implements HTTPSWeb.OnResponseListener {

    private HTTPSWeb web;
    private Gson gson;
    private Playlist playlist;
    private PlaylistActivity activity;

    public AuxControllerPlaylist(Playlist playlist, PlaylistActivity activity) {
        this.activity = activity;
        this.playlist = playlist;
        web = new HTTPSWeb();
        web.setListener(this);
        gson = new Gson();

        initTracks();
    }

    public void initTracks(){

        for (int i = 0; i < playlist.getTracks().getData().length; i++) {
            int j = i;
            new Thread(
                    () -> {
                        web.GETrequest(Constants.SEARCH_CALLBACK, Constants.TRACK_URL+playlist.getTracks().getData()[j].getId());
                    }
            ).start();
        }

    }

    @Override
    public void onResponse(int callbackID, String response) {
        Track track = gson.fromJson(response,Track.class);
        activity.runOnUiThread(
                () -> {
                    activity.getAdapter().addTrack(track);
                }
        );
    }
}
