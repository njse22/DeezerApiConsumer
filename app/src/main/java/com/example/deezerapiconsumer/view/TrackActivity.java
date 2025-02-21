package com.example.deezerapiconsumer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezerapiconsumer.R;
import com.example.deezerapiconsumer.controller.ControllerTrack;

public class TrackActivity extends AppCompatActivity {

    private ImageView imageTrack;
    private TextView textTitle;
    private TextView textArtist;
    private TextView textAlbum;
    private TextView textDuration;
    private Button listenBtn;
    private ControllerTrack controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        imageTrack = findViewById(R.id.imageTrack);
        textTitle = findViewById(R.id.textTitle);
        textArtist = findViewById(R.id.textArtist);
        textAlbum = findViewById(R.id.textAlbum);
        textDuration = findViewById(R.id.textDuration);
        listenBtn = findViewById(R.id.listenBtn);

        controller = new ControllerTrack(this);

    }

    public ImageView getImageTrack() {
        return imageTrack;
    }

    public TextView getTextTitle() {
        return textTitle;
    }

    public TextView getTextArtist() {
        return textArtist;
    }

    public TextView getTextAlbum() {
        return textAlbum;
    }

    public TextView getTextDuration() {
        return textDuration;
    }

    public Button getListenBtn() {
        return listenBtn;
    }
    
}
