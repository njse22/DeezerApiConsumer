package com.example.deezerapiconsumer.entity;

public class Creator {

    private String name;
    private long id;

    public Creator() {
    }

    public Creator(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
