package ru.job4j.inheritance;

public class Task {
    public String task;

    public Task(Customer customer) {
        this.task = customer.task;
    }
}
