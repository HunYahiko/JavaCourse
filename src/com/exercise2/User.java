package com.exercise2;

import com.exercise2.utility.ExerciseUtility;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private boolean isActive;
    private List<String> roles;
    private List<String> emails;
    private Double balance;
    private LocalDate registrationDate;
    
    public User() {
        this.name = "";
        this.isActive = false;
        this.balance = 0.0;
    }
    
    public User(String name, boolean isActive, List<String> roles, List<String> emails,
                Double balance, LocalDate registrationDate) {
        this.name = name;
        this.isActive = isActive;
        this.roles = roles;
        this.emails = emails;
        this.balance = balance;
        this.registrationDate = registrationDate;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean active) {
        isActive = active;
    }
    
    public List<String> getRoles() {
        return roles;
    }
    
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    
    public List<String> getEmails() {
        return emails;
    }
    
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
    
    public Double getBalance() {
        return balance;
    }
    
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    @Override
    public String toString() {
        StringBuilder userString = new StringBuilder();
        userString.append("Name: ")
                .append(name)
                .append(isActive ? ", Active: yes"  : ", Active: no ")
                .append(", Roles: { ");
        roles.forEach(role -> userString
                                      .append(role).append(", "));
        userString.append("}, Emails: { ");
        emails.forEach(email -> userString
                                        .append(email).append(", "));
        userString.append("}, Balance: ")
                .append(balance.toString())
                .append(", Registration Date: ")
                .append(registrationDate.toString());
        
        return userString.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        
        if (!(obj instanceof User)) return false;
        
        User user = (User) obj;
        
        return name.equals(user.name)
                && ExerciseUtility.equalLists(roles, user.roles)
                && ExerciseUtility.equalLists(emails, user.emails)
                && balance.equals(user.balance);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, roles, emails, balance);
    }
    
    @Override
    public int compareTo(User o) {
        if (this.equals(o)) return 0;
        
        if (name.compareTo(o.name) != 0 ) {
            return name.compareTo(o.name);
        } else {
            return balance > o.balance ? +1 : balance < o.balance ? -1 : 0;
        }
    }
}
