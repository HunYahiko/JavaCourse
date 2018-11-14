package com.exercise2;

import com.exercise2.Service.UserService;
import com.exercise2.utility.ExerciseUtility;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> fatherEmails = Arrays.asList("father@gmail.com", "father@yahoo.com", "family@gmail.com");
        List<String> motherEmails = Arrays.asList("mother@gmail.com", "mother@hotmail.com", "family@gmail.com");
        List<String> daugtherEmails = Arrays.asList("daughter@gmail.com", "daughter@hotmail.com", "family@gmail.com");
        List<String> sonEmails = Arrays.asList("son@gmail.com", "son@yahoo.com", "family@gmail.com");
        List<String> fatherRoles = Arrays.asList("father", "parent", "musician");
        List<String> motherRoles = Arrays.asList("mother", "parent", "baker");
        List<String> daughterRoles = Arrays.asList("daughter", "child", "student");
        List<String> sonRoles = Arrays.asList("son", "child", "pupil");
 
        
        User user1 = new User("Mother", false, motherRoles, motherEmails,5000.0, LocalDate.now().plusMonths(1));
        User user2 = new User("Father", true, fatherRoles, fatherEmails, 10000.0, LocalDate.now());
        User user3 = new User("Daughter", false, daughterRoles, daugtherEmails, 3000.0, LocalDate.now());
        User user4 = new User("Son", true, sonRoles, sonEmails, 2500.0, LocalDate.now().minusMonths(3));
        
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        UserService userService = new UserService();
        
        /*Sort distinct users*/
        users = users.stream()
                .distinct()
                .sorted().collect(Collectors.toList());
        
        /*Print min, max and average balance*/
        System.out.println(userService.getMaxBalance(users));
        System.out.println(userService.getMinBalance(users));
        System.out.println(userService.getAverageBalance(users));
        
        /*Partition users by active and locked*/
        Map<String, List<User>> partitionedUsers = userService.partitionByActivity(users);
        partitionedUsers.forEach((key, list) -> {
            System.out.println(key + " users: ");
            list.forEach(System.out::println);
            System.out.println();
        });
        
        /*Get list of emails*/
        System.out.println("\nEmail's list: ");
        userService.getListOfEmails(users).forEach(System.out::println);
        
        /*Group users by registration date(month)*/
        userService.groupByRegistrationDate(users).forEach((month, userList) -> {
            System.out.println("\nUsers registred in " + month.name() + " :");
            userList.forEach(System.out::println);
        });
        
        /*Group users by roles*/
        userService.groupByRoles(users).forEach((role, userList) -> {
            System.out.println("\nRole - " + role + ":");
            userList.forEach(System.out::println);
        });
        
        /*Get Set from List*/
        System.out.println("\nUsers from newly created Set:");
        userService.getUsersSet(users).forEach(System.out::println);
        
        /*Get number of non active users*/
        System.out.println("\nNumber of non active users: " + userService.countNonActiveUsers(users));
    
        /*Get user with balance greater than 1000.0*/
        System.out.println(userService.getUserWithGreaterBalance(1000.0, users));
        
        /*Print user's name*/
        System.out.println(userService.printUserNames(users));
        
        /*Cartesian product*/
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Character> characters = Arrays.asList('a', 'b', 'c');
        ExerciseUtility.cartesianProduct(integers, characters);
        
        System.out.println();
        
        /*Factorial*/
        System.out.println(ExerciseUtility.factorial(5));
    }
}
