package com.techverito.channel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Channel {
    private String name;
    private Long cost;

    public Channel(String name, Long cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).append(cost).toString();
    }
}
