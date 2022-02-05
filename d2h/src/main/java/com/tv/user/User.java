package com.techverito.user;

import com.techverito.subscription.domain.Subscription;

public class User {
    private Subscription subscriptions;
    private Account account;

    public User() {
    }

    public User(Subscription subscriptions, Account account) {
        this.subscriptions = subscriptions;
        this.account = account;
    }

    public Subscription getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Subscription subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
