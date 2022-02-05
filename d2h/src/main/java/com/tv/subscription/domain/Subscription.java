package com.techverito.subscription.domain;

import com.techverito.channel.domain.Channel;
import com.techverito.pack.domain.Pack;
import com.techverito.service.domain.LearnService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Subscription {

    private Pack pack;
    private Optional<LearnService> optionalService;
    private Optional<Set<Channel>> optionalChannel;
    private Integer numberOfMonths;

    public Subscription() {
        this.optionalChannel = Optional.of(new HashSet<>());
    }

    public Subscription(Pack pack, Integer numberOfMonths) {
        this.pack = pack;
        this.numberOfMonths = numberOfMonths;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public Optional<LearnService> getOptionalService() {
        return optionalService;
    }

    public void setOptionalService(Optional<LearnService> optionalService) {
        this.optionalService = optionalService;
    }

    public Optional<Set<Channel>> getOptionalChannel() {
        return optionalChannel;
    }

    public void setOptionalChannel(Optional<Set<Channel>> optionalChannel) {
        this.optionalChannel = optionalChannel;
    }

    public Integer getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(Integer numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }
}
