package com.exercise2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("google@gmail.com", "facebook@yahoo.com");
        List<String> roles1 = Arrays.asList("baker", "gamer");
        List<String> roles2 = Arrays.asList("singer", "musician");
        
        
        User user1 = new User("Peter", false, roles1, emails, 20.0, LocalDate.now());
        User user2 = new User("Laura", true, roles2, emails, 20.0, LocalDate.now());
        User user3 = new User("Peter", false, roles1, emails, 20.0, LocalDate.now());
        
        List<User> users = Arrays.asList(user1, user2, user3);
        
        users.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
