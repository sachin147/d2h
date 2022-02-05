package com.techverito.service.domain;

public class LearnEnglishService implements LearnService {

    private String name;

    public LearnEnglishService() {
        this.name = "LearnEnglish";
    }

    @Override
    public Long getCost() {
        return 200l;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).append(getCost()).toString();
    }
}
