package com.example.deezerapiconsumer.controller;

import android.content.Intent;
import android.text.style.UpdateLayout;
import android.view.View;
import android.widget.AdapterView;

import com.example.deezerapiconsumer.entity.Playlist;
import com.example.deezerapiconsumer.entity.Track;
import com.example.deezerapiconsumer.util.Constants;
import com.example.deezerapiconsumer.util.HTTPSWeb;
import com.example.deezerapiconsumer.view.PlaylistActivity;
import com.example.deezerapiconsumer.view.TrackActivity;
import com.google.gson.Gson;

public class ControllerPlaylist implements HTTPSWeb.OnResponseListener, AdapterView.OnItemClickListener {

    private PlaylistActivity activity;
    private Gson gson;
    private HTTPSWeb web;
    private AuxControllerPlaylist auxControllerPlaylist;

    public ControllerPlaylist(PlaylistActivity activity) {
        this.activity = activity;
        init();
    }


    public PlaylistActivity getActivity() {
        return activity;
    }

    public void setActivity(PlaylistActivity activity) {
        this.activity = activity;
    }

    public void init(){
        gson = new Gson();
        web = new HTTPSWeb();
        web.setListener(this);
        activity.getListViewTracks().setOnItemClickListener(this);

        new Thread(
                () -> {
                    web.GETrequest(Constants.SEARCH_CALLBACK, Constants.PLAYLIST_URL+activity.getItemId());
                }
        ).start();

    }

    @Override
    public void onResponse(int callbackID, String response) {
        Playlist playlist = gson.fromJson(response, Playlist.class);
        activity.runOnUiThread(
                () -> {
                    // La imagen ?
                    activity.getTextViewNameList().setText(playlist.getTitle());
                    activity.getTextViewDescription().setText(playlist.getDescription());
                    activity.getTextViewSongs().setText(playlist.getNb_tracks()+"");
                    activity.getTextViewFans().setText(playlist.getFans() + "");
                }
        );
        auxControllerPlaylist = new AuxControllerPlaylist(playlist, activity);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        new Thread(
                () -> {
                    Track track = (Track) activity.getAdapter().getItem(position);
                    Intent i = new Intent(activity, TrackActivity.class);
                    i.putExtra("title", track.getTitle());
                    i.putExtra("picture", track.getAlbum().getCover());
                    i.putExtra("artist", track.getArtist().getName());
                    i.putExtra("duration", track.getDuration());
                    i.putExtra("link", track.getPreview());
                    i.putExtra("id", track.getId());
                    i.putExtra("album", track.getAlbum().getTitle());
                    activity.startActivity(i);
                }
        ).start();
    }

}
