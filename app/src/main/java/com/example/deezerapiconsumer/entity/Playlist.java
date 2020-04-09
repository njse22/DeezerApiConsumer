package com.example.deezerapiconsumer.entity;

public class Playlist {

    private String title;
    private String description;
    private String link;
    private long nb_tracks;
    private String picture;
    private long fans;
    private User user;
    private TracksContainer tracks;
    private long id;

    public Playlist() {
    }

    public Playlist(String title, String description, String link,
                    int nb_tracks, String picture, long fans,
                    User user, TracksContainer data, long id) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.nb_tracks = nb_tracks;
        this.picture = picture;
        this.fans = fans;
        this.user = user;
        this.tracks = data;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getFans() {
        return fans;
    }

    public void setFans(long fans) {
        this.fans = fans;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TracksContainer getTracks() {
        return tracks;
    }

    public void setTracks(TracksContainer tracks) {
        this.tracks = tracks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
