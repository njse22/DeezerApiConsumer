package com.example.deezerapiconsumer.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.deezerapiconsumer.R;
import com.example.deezerapiconsumer.entity.Playlist;

import java.util.ArrayList;

public class PlayListSearchAdapter extends BaseAdapter {

    private ArrayList<Playlist> playlists;


    public PlayListSearchAdapter() {

        playlists = new ArrayList<Playlist>();
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
        notifyDataSetChanged();
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
    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View playlistview = inflater.inflate(R.layout.playlist_adapter, null);

        playlistview.findViewById(R.id.playlistImage);
        TextView textTitle = playlistview.findViewById(R.id.textTitle);
        TextView textCreator = playlistview.findViewById(R.id.textArtist);
        TextView textNTracks = playlistview.findViewById(R.id.textDate);

        textTitle.setText(playlists.get(position).getTitle());
        textCreator.setText(playlists.get(position).getUser().getName());
        textNTracks.setText("Songs: "+ playlists.get(position).getNb_tracks());

        final ImageView playlistImage = playlistview.findViewById(R.id.playlistImage);

        String url = playlists.get(position).getPicture();

        Glide
                .with(playlistview)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(playlistImage);

        return playlistview;
    }

}
