package ru.job4j.inheritance;

public class Customer {
    public String name;
    public String surname;
    public String task;
    public String[] tasks = {"Написать программу", "построить"};

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.task = this.tasks[0];
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String[] getTasks() {
        return this.tasks;
    }

}
