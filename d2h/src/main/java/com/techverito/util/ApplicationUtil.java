package com.techverito.util;

import com.techverito.channel.domain.Channel;
import com.techverito.pack.domain.GoldPack;
import com.techverito.pack.domain.Pack;
import com.techverito.pack.domain.SilverPack;
import com.techverito.service.domain.LearnCookingService;
import com.techverito.service.domain.LearnEnglishService;
import com.techverito.service.domain.LearnService;
import com.techverito.subscription.domain.Subscription;
import com.techverito.user.Account;
import com.techverito.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ApplicationUtil {

    private static User user;
    private static Map<String, Channel> channelMap = new HashMap<>();
    private static Map<String, Pack> packMap = new HashMap<>();
    private static Map<String, LearnService> learnServiceMap = new HashMap<>();

    public static void initializeUser() {
        Subscription subscription = initializeSubscription();
        Account account = initializeAccount();
        user = new User(subscription, account);
    }

    private static Subscription initializeSubscription() {
        return new Subscription();
    }

    private static Account initializeAccount() {
        return  new Account(100l, "Test User", "user@test.com", "8080808080");
    }

    public static User getUser() {
        return user;
    }

    public static Scanner getScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public static Map<String, Channel> getChannelMap() {
        channelMap.put("Zee", new Channel("Zee", 10l));
        channelMap.put("Sony",new Channel("Sony", 15l));
        channelMap.put("Star Plus", new Channel("Star Plus", 20l));
        channelMap.put("Discovery", new Channel("Discovery", 10l));
        channelMap.put("NatGeo", new Channel("NatGeo", 20l));
        return channelMap;
    }

    public static Map<String, Pack> getPack() {
        packMap.put("G", new GoldPack());
        packMap.put("S", new SilverPack());
        return packMap;
    }

    public static Map<String, LearnService> getLearnServiceMap() {
        learnServiceMap.put("LearnEnglish", new LearnEnglishService());
        learnServiceMap.put("LearnCooking", new LearnCookingService());
        return learnServiceMap;
    }
}
