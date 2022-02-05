package com.techverito.pack.domain;

import com.techverito.channel.domain.Channel;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashSet;
import java.util.Set;

import static com.techverito.util.ApplicationUtil.getChannelMap;

public class GoldPack extends Pack {

    private String name;
    private Set<Channel> channels;

    public GoldPack() {
        this.name = "Gold";
        this.channels = new HashSet<>();
        channels.add(getChannelMap().get("Zee"));
        channels.add(getChannelMap().get("Sony"));
        channels.add(getChannelMap().get("Star Plus"));
        channels.add(getChannelMap().get("Discovery"));
        channels.add(getChannelMap().get("NatGeo"));
    }

    public Set<Channel> getChannels() {
        return channels;
    }

    @Override
    public Long getCost() {
        return 100l;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addChannel(String channel) {
        //add channel from predefined map
        //if invalid, throw InvalidChannelExceptions
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).append(channels).toString();
    }
}
