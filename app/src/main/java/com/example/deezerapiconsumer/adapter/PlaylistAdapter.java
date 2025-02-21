package com.example.deezerapiconsumer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.deezerapiconsumer.R;
import com.example.deezerapiconsumer.entity.Track;

import java.util.ArrayList;

public class PlaylistAdapter extends BaseAdapter {

    private ArrayList<Track> tracks;

    public PlaylistAdapter() {
        tracks = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return tracks.size();
    }

    @Override
    public Object getItem(int position) {
        return tracks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View trackListview = inflater.inflate(R.layout.track_adapter, null);

        final ImageView playlistImage = trackListview.findViewById(R.id.playlistImage);
        TextView textTitle = trackListview.findViewById(R.id.textTitle); // titulo
        TextView textArtist = trackListview.findViewById(R.id.textArtist); // artista
        TextView textDate = trackListview.findViewById(R.id.textDate); // año lanzamiento

        textTitle.setText(tracks.get(position).getTitle());
        textArtist.setText("Artista: " + tracks.get(position).getArtist().getName());
        textDate.setText( "Fecha: " + tracks.get(position).getRelease_date());

        String url = tracks.get(position).getAlbum().getCover();

        Glide
                .with(trackListview)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(playlistImage);

        return trackListview;
    }

    public void addTrack(Track track){
        tracks.add(track);
        notifyDataSetChanged();
    }
}
