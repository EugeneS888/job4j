package ru.job4j.banks;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String passport;
    List<Account> usAcc = new ArrayList<>();

    public User() {
    }

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public void addUser(User user) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }
}
