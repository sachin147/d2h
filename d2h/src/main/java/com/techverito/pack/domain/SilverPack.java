package com.techverito.pack.domain;

import com.techverito.channel.domain.Channel;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashSet;
import java.util.Set;

import static com.techverito.util.ApplicationUtil.getChannelMap;

public class SilverPack extends Pack {

    private String name;
    private Set<Channel> channels;

    public SilverPack() {
        this.name = "Silver";
        this.channels = new HashSet<>();
        channels.add(getChannelMap().get("Zee"));
        channels.add(getChannelMap().get("Sony"));
        channels.add(getChannelMap().get("Star Plus"));
    }

    public Set<Channel> getChannels() {
        return channels;
    }

    @Override
    public Long getCost() {
        return 50l;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addChannel(String channel) {
        //add channel from predefined map
        //if invalid, throw InvalidChannelException
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).append(channels).toString();
    }
}
