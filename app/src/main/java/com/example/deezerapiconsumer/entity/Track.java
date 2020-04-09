package com.example.deezerapiconsumer.entity;

public class Track {

    private long id;
    private String title;
    private String link;
    private long duration;
    private String release_date;
    private String preview;
    private Artist artist;
    private Album album;

    public Track() {
    }

    public Track(long id,String title, String link, long duration, String release_date, String preview, Artist artist, Album album) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.duration = duration;
        this.release_date = release_date;
        this.preview = preview;
        this.artist = artist;
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
