package com.example.deezerapiconsumer.controller;

import android.view.View;

import com.example.deezerapiconsumer.view.ui.MainActivity;
import com.example.deezerapiconsumer.entity.Playlist;
import com.example.deezerapiconsumer.util.Constants;
import com.example.deezerapiconsumer.util.HTTPSWeb;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ControllerMainActivity implements View.OnClickListener, HTTPSWeb.OnResponseListener {

    private MainActivity activity;
    private HTTPSWeb web;
    private Gson gson;
    private Playlist playlist;
    private ArrayList<Playlist> data;

    public ControllerMainActivity(MainActivity activity) {
        this.activity = activity;
        init();
    }

    public void init(){
        activity.getImgButtonSearch().setOnClickListener(this);
        web = new HTTPSWeb();
        gson = new Gson();
        playlist = new Playlist();
        data = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        String search = activity.getEditTextSearch().getText().toString();
        String url = "https://api.deezer.com/search/playlist/?q="+ search +"&index=0&output=json";

        new Thread(
                () -> {
                    web.GETrequest(Constants.SEARCH_CALLBACK, url);
                }
        ).start();
    }

    @Override
    public void onResponse(int callbackID, String response) {
        playlist = gson.fromJson(response, Playlist.class);


    }
}
