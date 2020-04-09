package com.example.deezerapiconsumer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.deezerapiconsumer.R;
import com.example.deezerapiconsumer.controller.ControllerMain;
import com.example.deezerapiconsumer.adapter.PlayListSearchAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPlaylist;
    private ImageButton imgButtonSearch;
    private EditText editTextSearch;
    private PlayListSearchAdapter adapter;
    private ControllerMain controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPlaylist = findViewById(R.id.listViewPlaylists);
        imgButtonSearch = findViewById(R.id.imageButtonSearch);
        editTextSearch = findViewById(R.id.editTextSearch);

        adapter = new PlayListSearchAdapter();
        listViewPlaylist.setAdapter(adapter);
        controller = new ControllerMain(this);

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

    public PlayListSearchAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(PlayListSearchAdapter adapter) {
        this.adapter = adapter;
    }

    public ControllerMain getController() {
        return controller;
    }

    public void setController(ControllerMain controller) {
        this.controller = controller;
    }

}
