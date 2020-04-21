package com.example.deezerapiconsumer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.deezerapiconsumer.R;
import com.example.deezerapiconsumer.adapter.SearchPlaylistAdapter;
import com.example.deezerapiconsumer.controller.ControllerMain;

public class MainActivity extends AppCompatActivity {

    private ImageButton imgButtonSearch;
    private EditText editTextSearch;
    private ControllerMain controller;
    private RecyclerView recyclerView;
    private SearchPlaylistAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgButtonSearch = findViewById(R.id.imageButtonSearch);
        editTextSearch = findViewById(R.id.editTextSearch);
        recyclerView = findViewById(R.id.listViewPlaylists);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SearchPlaylistAdapter(this);
        recyclerView.setAdapter(adapter);

        controller = new ControllerMain(this);
    }


    public SearchPlaylistAdapter getAdapter() {
        return adapter;
    }

    public ImageButton getImgButtonSearch() {
        return imgButtonSearch;
    }

    public EditText getEditTextSearch() {
        return editTextSearch;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
