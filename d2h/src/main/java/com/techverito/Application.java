package com.techverito;

import com.techverito.processor.Processor;

import static com.techverito.processor.Processor.getInstance;
import static com.techverito.util.ApplicationUtil.getScanner;
import static com.techverito.util.ApplicationUtil.initializeUser;

public class Application {

    public static void main(String []args) {
        initializeUser();
        printOptions();
        final Processor instance = getInstance();
        System.out.println("Enter option number : ");
        int option = getScanner().nextInt();
        while(option != 9) {
            instance.process(option);
            printOptions();
            option = getScanner().nextInt();
        }
        System.out.println("Exit");
    }

    private static void printOptions() {
        System.out.println("1. View current balance in the account\n" +
                "2. Recharge Account\n" +
                "3. View available packs, channels and services\n" +
                "4. Subscribe to base packs\n" +
                "5. Add channels to an existing subscription\n" +
                "6. Subscribe to special services\n" +
                "7. View current subscription details\n" +
                "8. Update email and phone number for notifications\n" +
                "9. Exit");
    }
}
