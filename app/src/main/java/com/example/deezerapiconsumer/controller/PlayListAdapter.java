package com.example.deezerapiconsumer.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezerapiconsumer.R;
import com.example.deezerapiconsumer.entity.Playlist;
import com.example.deezerapiconsumer.util.Constants;
import com.example.deezerapiconsumer.util.HTTPSWeb;

import java.util.ArrayList;

public class PlayListAdapter extends BaseAdapter implements  HTTPSWeb.OnResponseListener{

    private ArrayList<Playlist> playlists;
    private HTTPSWeb web;

    private ImageView playlistImage;
    private TextView textTitle;
    private TextView textCreator;
    private TextView textNTracks;

    public PlayListAdapter() {
        playlists = new ArrayList<>();
        web = new HTTPSWeb();

    }

    @Override
    public int getCount() {
        return playlists.size();
    }

    @Override
    public Object getItem(int position) {
        return playlists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Se carga un objeto visible a la vez
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View playlistview = inflater.inflate(R.layout.playlist_adapter, null);

        playlistImage =  playlistview.findViewById(R.id.playlistImage);
        textTitle = playlistview.findViewById(R.id.textTitle);
        textCreator = playlistview.findViewById(R.id.textCreator);
        textNTracks = playlistview.findViewById(R.id.textNTracks);

        textTitle.setText(playlists.get(position).getTitle());
        textCreator.setText(playlists.get(position).getCreator().getName());
        textNTracks.setText(playlists.get(position).getNb_tracks());

        String picture = playlists.get(position).getPicture();

        new Thread(
                () -> {
                    web.GETrequest(Constants.SEARCH_CALLBACK,picture);
                }
        ).start();
        return playlistview;
    }

    @Override
    public void onResponse(int callbackID, String response) {
        Bitmap bm = BitmapFactory.decodeByteArray(response.getBytes(),0,response.length());
        playlistImage.setImageBitmap(bm);
    }
}
