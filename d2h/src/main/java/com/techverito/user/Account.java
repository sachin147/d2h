package com.techverito.user;

public class Account {

    private Long balance;
    private String name;
    private String email;
    private String contactNumber;

    public Account(Long balance, String name, String email, String contactNumber) {
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
