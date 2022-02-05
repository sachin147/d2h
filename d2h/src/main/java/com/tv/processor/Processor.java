package com.techverito.processor;

import com.techverito.channel.domain.Channel;
import com.techverito.notification.EmailNotification;
import com.techverito.notification.Notification;
import com.techverito.notification.SMSNotification;
import com.techverito.pack.domain.Pack;
import com.techverito.service.domain.LearnService;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static com.techverito.calculator.Calculator.getDiscount;
import static com.techverito.calculator.Calculator.getSubscriptionAmount;
import static com.techverito.calculator.Calculator.updateBalance;
import static com.techverito.util.ApplicationUtil.getChannelMap;
import static com.techverito.util.ApplicationUtil.getLearnServiceMap;
import static com.techverito.util.ApplicationUtil.getPack;
import static com.techverito.util.ApplicationUtil.getScanner;
import static com.techverito.util.ApplicationUtil.getUser;

;

public class Processor {

    private Notification emailNotification;
    private Notification smsNotification;
    private static Processor processor;

    private Processor() {
        this.emailNotification = new EmailNotification();
        this.smsNotification = new SMSNotification();
    }

    public static Processor getInstance()
    {
        if (processor == null)
            processor = new Processor();
        return processor;
    }

    public void process(Integer option) {
        switch(option) {
            case 1 :
                viewBalance();
                break;
            case 2 :
                recharge();
                break;
            case 3 :
                view();
                break;
            case 4 :
                subscribePack();
                break;
            case 5 :
                addChannel();
                break;
            case 6 :
                subscribeService();
                break;
            case 7:
                viewSubscription();
                break;
            case 8:
                updateAccount();
                break;
            default :
                System.out.println("Invalid option");
                break;
        }
    }

    private static void viewBalance() {
        System.out.println(getUser().getAccount().getBalance());
    }

    private static void recharge() {
        System.out.println("Enter the amount to recharge");
        long rechargeAmount = getScanner().nextLong();
        long updatedBalance = getUser().getAccount().getBalance() + rechargeAmount;
        getUser().getAccount().setBalance(updatedBalance);
        System.out.println(String.format("Recharge completed successfully. Current balance is %d", getUser().getAccount().getBalance()));
    }

    private void view() {
        System.out.println("Available packs for subscription");
        final Map<String, Pack> packs = getPack();
        packs.forEach((name, pack) -> System.out.println(pack));

        System.out.println("Available channels for subscription");
        final Map<String, Channel> channelMap = getChannelMap();
        channelMap.forEach((name, channel) -> System.out.println(channel));

        System.out.println("Available services for subscription");
        final Map<String, LearnService> learnServiceMap = getLearnServiceMap();
        learnServiceMap.forEach((name, learnService) -> System.out.println(learnService));
    }

    private void subscribePack() {
        System.out.println("Enter the Pack you wish to subscribe: (Silver: ‘S’, Gold: ‘G’)");
        String packCode = getScanner().next();
        System.out.println("Enter the months: ");
        int numberOfMonths = getScanner().nextInt();
        final Pack pack = getPack().get(packCode);
        getUser().getSubscriptions().setPack(pack);
        getUser().getSubscriptions().setNumberOfMonths(numberOfMonths);
        System.out.println(String.format("You have successfully subscribed the following packs - %s", pack.getName()));
        System.out.println(String.format("Monthly price: ", pack.getCost()));
        System.out.println(String.format("No of months: %d", numberOfMonths));
        final long subscriptionAmount = getSubscriptionAmount(pack.getCost(), numberOfMonths);
        System.out.println(String.format("Subscription Amount: %d", subscriptionAmount));
        final double discount = getDiscount(pack.getCost(), numberOfMonths);
        System.out.println(String.format("Discount applied: %f", discount));
        final double finalPrice = subscriptionAmount - discount;
        System.out.println(String.format("Final Price after discount: %f", finalPrice));
        updateBalance(finalPrice);
        System.out.println(String.format("Account balance: %d", getUser().getAccount().getBalance()));
        emailNotification.send();
        smsNotification.send();
    }

    private void addChannel() {
        System.out.println("Enter channel names to add (separated by commas): ");
        String channelsToAdd = getScanner().nextLine();
        String []channels = channelsToAdd.split(",");
        long amountToDeduct = 0l;
        final Optional<Set<Channel>> optionalChannelSet = getUser().getSubscriptions().getOptionalChannel();
        for(String channel : channels) {
            Channel channelToAdd = getChannelMap().get(channel.trim());
            optionalChannelSet.get().add(channelToAdd);
            amountToDeduct += channelToAdd.getCost();
        }
        System.out.println("Channels added successfully.");
        updateBalance(amountToDeduct);
    }

    private void subscribeService() {
        System.out.println("Enter the service name: ");
        String service = getScanner().next();
        final LearnService learnService = getLearnServiceMap().get(service.trim());
        getUser().getSubscriptions().setOptionalService(Optional.of(learnService));
        System.out.println("Service subscribed successfully");
        updateBalance(learnService.getCost());
        System.out.println(String.format("Account balance: %d", getUser().getAccount().getBalance()));
        emailNotification.send();
        smsNotification.send();
    }

    private void viewSubscription() {
        System.out.println("View current subscription details");
        System.out.println("Currently subscribed packs and channels:");
        System.out.println(getUser().getSubscriptions().getPack().getName() + " " + getUser().getSubscriptions().getOptionalChannel().toString());
        System.out.println("Currently subscribed services:");
        System.out.println(getUser().getSubscriptions().getOptionalService().get());
    }

    private void updateAccount() {
        System.out.println("Update email and phone number for notifications");
        System.out.println("Enter the email: ");
        String emailToUpdate = getScanner().next();
        getUser().getAccount().setEmail(emailToUpdate);
        System.out.println("Enter phone: ");
        String numberToUpdate = getScanner().next();
        getUser().getAccount().setContactNumber(numberToUpdate);
        System.out.println("Email and Phone updated successfully");
    }
}
