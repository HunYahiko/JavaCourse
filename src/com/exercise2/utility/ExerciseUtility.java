package com.exercise2.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExerciseUtility {
    
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
    
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
