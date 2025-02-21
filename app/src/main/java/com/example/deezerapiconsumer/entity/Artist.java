package com.example.deezerapiconsumer.entity;

public class Artist {

    private long id;
    private String name ;
    private String link;
    private String picture;

    public Artist() {
    }

    public Artist(long id,  String name, String link, String picture) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.picture = picture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
