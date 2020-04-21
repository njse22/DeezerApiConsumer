package com.example.deezerapiconsumer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.deezerapiconsumer.R;
import com.example.deezerapiconsumer.adapter.PlaylistAdapter;
import com.example.deezerapiconsumer.controller.ControllerPlaylist;

public class PlaylistActivity extends AppCompatActivity {

    private ImageView imageViewList;
    private TextView textViewNameList;
    private TextView textViewDescription;
    private TextView textViewSongs;
    private TextView textViewFans;
    private ListView listViewTracks;
    private PlaylistAdapter adapter;
    private ControllerPlaylist controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        imageViewList = findViewById(R.id.imageViewList);
        textViewNameList = findViewById(R.id.textViewNameList);
        textViewDescription = findViewById(R.id.textViewDescription);
        textViewSongs = findViewById(R.id.textViewSongs);
        textViewFans = findViewById(R.id.textViewFans);
        adapter = new PlaylistAdapter();
        listViewTracks = findViewById(R.id.listViewTracks);
        listViewTracks.setAdapter(adapter);
        controller = new ControllerPlaylist(this);

    }

    public long getItemId(){
        return (long)getIntent().getExtras().get("id");
    }

    public ImageView getImageViewList() {
        return imageViewList;
    }

    public TextView getTextViewNameList() {
        return textViewNameList;
    }

    public TextView getTextViewDescription() {
        return textViewDescription;
    }

    public TextView getTextViewSongs() {
        return textViewSongs;
    }

    public TextView getTextViewFans() {
        return textViewFans;
    }

    public ListView getListViewTracks() {
        return listViewTracks;
    }

    public PlaylistAdapter getAdapter() {
        return adapter;
    }

}
