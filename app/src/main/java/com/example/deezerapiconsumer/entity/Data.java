package com.example.deezerapiconsumer.entity;

public class Data {

    private Track[] tracks;

    public Data() {
    }

    public Data(Track[] tracks) {
        this.tracks = tracks;
    }

    public Track[] getTracks() {
        return tracks;
    }

    public void setTracks(Track[] tracks) {
        this.tracks = tracks;
    }
}
