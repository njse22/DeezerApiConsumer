package com.example.deezerapiconsumer.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.deezerapiconsumer.R;
import com.example.deezerapiconsumer.controller.ControllerMainActivity;
import com.example.deezerapiconsumer.controller.PlayListAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPlaylist;
    private ImageButton imgButtonSearch;
    private EditText editTextSearch;
    private PlayListAdapter adapter;
    private ControllerMainActivity controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPlaylist=findViewById(R.id.listViewPlaylists);
        imgButtonSearch=findViewById(R.id.imageButtonSearch);
        editTextSearch=findViewById(R.id.editTextSearch);
        adapter = new PlayListAdapter();
        listViewPlaylist.setAdapter(adapter);

        controller = new ControllerMainActivity(this);

    }

    public ListView getListViewPlaylist() {
        return listViewPlaylist;
    }

    public void setListViewPlaylist(ListView listViewPlaylist) {
        this.listViewPlaylist = listViewPlaylist;
    }

    public ImageButton getImgButtonSearch() {
        return imgButtonSearch;
    }

    public void setImgButtonSearch(ImageButton imgButtonSearch) {
        this.imgButtonSearch = imgButtonSearch;
    }

    public EditText getEditTextSearch() {
        return editTextSearch;
    }

    public void setEditTextSearch(EditText editTextSearch) {
        this.editTextSearch = editTextSearch;
    }

    public PlayListAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(PlayListAdapter adapter) {
        this.adapter = adapter;
    }
}
