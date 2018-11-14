package com.exercise2.utility;

import com.exercise2.User;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ExerciseUtility {
    
    public static Supplier<User> defaultUser = () -> new User("Default");
    
    public static boolean equalLists(List<String> firstEmails, List<String> secondEmails)  {
        if (firstEmails == null && secondEmails == null) return true;
        
        if (firstEmails != null && secondEmails == null || firstEmails == null && secondEmails != null ||
                    firstEmails.size() != secondEmails.size()) return false;
        
        firstEmails = new ArrayList<>(firstEmails);
        secondEmails = new ArrayList<>(secondEmails);
    
        Collections.sort(firstEmails);
        Collections.sort(secondEmails);
        
        return firstEmails.equals(secondEmails);
    }
    
    public static void cartesianProduct(List<Integer> integers, List<Character> characters) {
        List<Map<Integer, Character>> cartesianProduct = new ArrayList<>();
    
        integers.forEach(integer -> characters.forEach(character -> {
            Map<Integer, Character> intermediateMap = new HashMap<>();
            intermediateMap.put(integer, character);
            cartesianProduct.add(intermediateMap);
        }));
    
        cartesianProduct.forEach(map -> map.forEach((key, value) -> {
            System.out.print("(" + key + ", " + value + ")");
        }));
    }
    
    public static Integer factorial(Integer number) {
        return IntStream.rangeClosed(2, number).reduce(1, (x, y) -> x * y);
    }
}
