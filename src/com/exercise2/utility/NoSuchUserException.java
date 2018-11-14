package com.exercise2.utility;

public class NoSuchUserException extends Exception {
    
    public NoSuchUserException() {
        super("No such user found!");
        System.out.println("No such user was found!");
    }
    
    public NoSuchUserException(String message) {
        super(message);
        System.out.println(message);
    }
}
