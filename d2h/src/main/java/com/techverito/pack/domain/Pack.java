package com.techverito.pack.domain;

public abstract class Pack {
    public abstract Long getCost();

    public abstract String getName();

    public abstract void addChannel(String channel);
}
