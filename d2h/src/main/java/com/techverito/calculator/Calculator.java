package com.techverito.calculator;

import static com.techverito.util.ApplicationUtil.getUser;

public class Calculator {

    public static long getSubscriptionAmount(Long cost, int numberOfMonths) {
        return cost * numberOfMonths;
    }

    public static double getDiscount(Long cost, int numberOfMonths) {
        double discount = 0;
        if(numberOfMonths >= 3) {
            return (cost * 0.1);
        }
        return discount;
    }

    public static void updateBalance(double finalPrice) {
        long newBalance = (long) (getUser().getAccount().getBalance() - finalPrice);
        getUser().getAccount().setBalance(newBalance);
    }
}
