package com.techverito.service.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LearnCookingService implements LearnService {

    private String name;

    public LearnCookingService() {
        this.name = "LearnCooking";
    }

    @Override
    public Long getCost() {
        return 100l;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).append(getCost()).toString();
    }
}
