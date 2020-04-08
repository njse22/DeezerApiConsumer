package com.example.deezerapiconsumer.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezerapiconsumer.R;

public class SongActivity extends AppCompatActivity {

    private ImageView imageSong;
    private TextView nameSong;
    private TextView artistSong;
    private TextView albumSong;
    private Button listenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        imageSong  = findViewById(R.id.imageSong);
        nameSong   = findViewById(R.id.nameSong);
        artistSong = findViewById(R.id.artistSong);
        albumSong  = findViewById(R.id.albumSong);
        listenBtn  = findViewById(R.id.listenBtn);

    }

    public ImageView getImageSong() {
        return imageSong;
    }

    public void setImageSong(ImageView imageSong) {
        this.imageSong = imageSong;
    }

    public TextView getNameSong() {
        return nameSong;
    }

    public void setNameSong(TextView nameSong) {
        this.nameSong = nameSong;
    }

    public TextView getArtistSong() {
        return artistSong;
    }

    public void setArtistSong(TextView artistSong) {
        this.artistSong = artistSong;
    }

    public TextView getAlbumSong() {
        return albumSong;
    }

    public void setAlbumSong(TextView albumSong) {
        this.albumSong = albumSong;
    }

    public Button getListenBtn() {
        return listenBtn;
    }

    public void setListenBtn(Button listenBtn) {
        this.listenBtn = listenBtn;
    }
}
