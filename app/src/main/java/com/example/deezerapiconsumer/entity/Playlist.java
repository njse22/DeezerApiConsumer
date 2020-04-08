package com.example.deezerapiconsumer.entity;

public class Playlist {

    private String title;
    private String description;
    private String link;
    private int nb_tracks;
    private String picture;
    private String fans;
    private Creator creator;
    private Data data;

    public Playlist() {
    }

    public Playlist(String title, String description, String link, int nb_tracks, String picture, String fans, Creator creator, Data data) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.nb_tracks = nb_tracks;
        this.picture = picture;
        this.fans = fans;
        this.creator = creator;
        this.data = data;
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

    public int getNb_tracks() {
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

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
