package com.exercise2.Service;

import com.exercise2.User;
import com.exercise2.utility.ExerciseUtility;
import com.exercise2.utility.NoSuchUserException;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    
    private Comparator<User> balanceComparator = Comparator.comparing(User::getBalance);
    
    public Double getMinBalance(List<User> users) {
        return Optional.of(users.stream().min(balanceComparator).get().getBalance()).orElse(0.0);
    }
    
    public Double getMaxBalance(List<User> users) {
        return Optional.of(users.stream().max(balanceComparator).get().getBalance()).orElse(0.0);
    }
    
    public Double getAverageBalance(List<User> users) {
        return users.stream()
                .mapToDouble(User::getBalance)
                .sum() / users.size();
    }
    
    public Map<String, List<User>> partitionByActivity(List<User> users) {
        Map<String, List<User>> partitionedUsers = new HashMap<>();
        partitionedUsers.put("Active", users.stream()
                                               .filter(User::isActive)
                                               .collect(Collectors.toList()));
        partitionedUsers.put("Locked", users.stream()
                                               .filter(user -> !user.isActive())
                                               .collect(Collectors.toList()));
        
        return partitionedUsers;
    }
    
    public List<String> getListOfEmails(List<User> users) {
        return users.stream()
                .map(User::getEmails)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }
    
    public Map<Month, List<User>> groupByRegistrationDate(List<User> users) {
        /*Group by month*/
        Map<Month, List<User>> groupedUsers = new HashMap<>();
        users.forEach(user -> {
            if (!groupedUsers.containsKey(user.getRegistrationDate().getMonth())) {
                groupedUsers.put(user.getRegistrationDate().getMonth(), new ArrayList<>());
            }
            groupedUsers.get(user.getRegistrationDate().getMonth()).add(user);
        });
        return groupedUsers;
    }
    
    public Map<String, List<User>> groupByRoles(List<User> users) {
        Map<String, List<User>> groupedUsers = new HashMap<>();
        
        users.stream()
                .map(User::getRoles)
                .flatMap(Collection::stream)
                .distinct()
                .forEach(role -> groupedUsers.put(role, new ArrayList<>()));
        
        users.forEach(user -> user.getRoles().forEach(role -> {
            groupedUsers.get(role).add(user);
        }));
        
        return groupedUsers;
    }
    
    public Set<User> getUsersSet(List<User> users) {
        return new HashSet<>(users);
        // users.stream().collect(Collectors.toSet())
    }
    
    public Integer countNonActiveUsers(List<User> users) {
        return Math.toIntExact(users.stream()
                .filter(user -> !user.isActive())
                .count());
    }
    
    public String getUserWithGreaterBalance(Double balance, List<User> users) {
        User foundUser = users.stream()
                .filter(user -> user.getBalance() >= balance)
                .findFirst()
                .orElseGet(ExerciseUtility.defaultUser);
        
        if (!foundUser.getName().equals("Default"))
            return foundUser.toString();
        else return "No such user was found!";
    }
    
    public String printUserNames(List<User> users) {
        StringBuilder nameList = new StringBuilder();
        users.stream().map(User::getName)
                .forEach(name -> nameList.append(name).append(", "));
        return nameList.toString();
    }
}
