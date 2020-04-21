package com.example.deezerapiconsumer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.deezerapiconsumer.R;
import com.example.deezerapiconsumer.entity.Playlist;

import java.util.ArrayList;

public class SearchPlaylistAdapter extends RecyclerView.Adapter<SearchPlaylistAdapter.Holder> {

    public ArrayList<Playlist> playlists;
    private Context context;
    private Holder holder;

    public SearchPlaylistAdapter(Context context) {
        this.playlists = new ArrayList<>(10);
        this.context = context; // actividad
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Holder getHolder() {
        return holder;
    }

    public Object getItem(int position) {
        return playlists.get(position);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.playlist_adapter,parent,false);
        holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        TextView textTitle = holder.playlistview.findViewById(R.id.textTitle); // titulo
        TextView textArtist = holder.playlistview.findViewById(R.id.textArtist); // artista
        TextView textDate = holder.playlistview.findViewById(R.id.textDate); // año lanzamiento

        textTitle.setText(playlists.get(position).getTitle());
        textArtist.setText(playlists.get(position).getUser().getName());
        textDate.setText( "Songs: " + playlists.get(position).getNb_tracks());

        final ImageView imageView = holder.playlistImage;

        String url = playlists.get(position).getPicture();

        Glide
                .with(holder.playlistview)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.playlistImage);

        holder.getPlaylistview().setActivated(true);

    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        protected View playlistview;
        protected TextView textTitle;
        protected TextView textCreator;
        protected TextView textNTracks;
        protected ImageView playlistImage;

        public Holder(View trackListview) {
            super(trackListview);
            this.playlistview = trackListview;
            this.textTitle = playlistview.findViewById(R.id.textTitle);
            this.textCreator = playlistview.findViewById(R.id.textArtist);
            this.textNTracks = playlistview.findViewById(R.id.textDate);
            this.playlistImage = playlistview.findViewById(R.id.playlistImage);

        }

        public View getPlaylistview() {
            return playlistview;
        }
    }


}
