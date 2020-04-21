package com.example.deezerapiconsumer.controller;

import android.content.Intent;
import android.view.View;

import com.example.deezerapiconsumer.R;
import com.example.deezerapiconsumer.entity.Playlist;
import com.example.deezerapiconsumer.entity.PlaylistContainer;
import com.example.deezerapiconsumer.util.Constants;
import com.example.deezerapiconsumer.util.HTTPSWeb;
import com.example.deezerapiconsumer.view.MainActivity;
import com.example.deezerapiconsumer.view.PlaylistActivity;
import com.google.gson.Gson;

public class ControllerMain implements View.OnClickListener, HTTPSWeb.OnResponseListener, RecyclerTouchListener.ClickListener {

    private MainActivity activity;
    private HTTPSWeb web;
    private Gson gson;
    private PlaylistContainer container;

    public ControllerMain(MainActivity activity) {
        this.activity = activity;
        init();
    }

    private void init(){
        web = new HTTPSWeb();
        web.setListener(this);
        gson = new Gson();
        activity.getImgButtonSearch().setOnClickListener(this);

        activity.getRecyclerView().addOnItemTouchListener(new RecyclerTouchListener(
                activity.getApplicationContext(), activity.getRecyclerView(), this
        ));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButtonSearch:
                String search = activity.getEditTextSearch().getText().toString();
                String url = Constants.SEARCH_URL + search + Constants.JSON_FORMAT;
                new Thread(
                        () -> {
                            web.GETrequest(Constants.SEARCH_CALLBACK, url);
                        }
                ).start();
                break;
        }
    }


    @Override
    public void onClick(View view, int position) {
        long itemId = ((Playlist)(activity.getAdapter().getItem(position))).getId();
        Intent i = new Intent(activity, PlaylistActivity.class);
        i.putExtra("id", itemId);
        activity.startActivity(i);
    }

    @Override
    public void onLongClick(View view, int position) {

    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID){
            case Constants.SEARCH_CALLBACK:
                container = gson.fromJson(response, PlaylistContainer.class);
                activity.runOnUiThread(
                        () -> {
                            for (int i = 0; i < container.getData().size(); i++ ){
                                activity.getAdapter().getPlaylists().add(container.getData().get(i));
                                activity.getAdapter().notifyDataSetChanged();
                            }
                        }
                );
                break;
        }
    }


}

