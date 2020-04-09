package com.example.deezerapiconsumer.entity;

import java.util.ArrayList;

public class PlaylistContainer {

    private ArrayList<Playlist> data;
    private int total;
    private String next;

    public PlaylistContainer() {
    }

    public PlaylistContainer(ArrayList<Playlist> data, int total, String next) {
        this.data = data;
        this.total = total;
        this.next = next;
    }

    public ArrayList<Playlist> getData() {
        return data;
    }

    public void setData(ArrayList<Playlist> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
