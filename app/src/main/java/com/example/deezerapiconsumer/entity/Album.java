package com.example.deezerapiconsumer.entity;

public class Album {

    private String title;
    private String link;
    private String cover;

    public Album() {
    }

    public Album(String title, String link,String cover) {
        this.title = title;
        this.link = link;
        this.cover = cover;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
