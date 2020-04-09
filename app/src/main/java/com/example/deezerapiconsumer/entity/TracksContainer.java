package com.example.deezerapiconsumer.entity;

public class TracksContainer {

    private Track[] data;

    public TracksContainer() {
    }

    public TracksContainer(Track[] tracks) {
        this.data = tracks;
    }

    public Track[] getData() {
        return data;
    }

    public void setData(Track[] data) {
        this.data = data;
    }
}
