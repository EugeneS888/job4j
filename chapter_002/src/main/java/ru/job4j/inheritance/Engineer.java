package ru.job4j.inheritance;

public class Engineer extends Profession {
    public long workTime;

    public Task getTask(Customer customer) {
        Task task = new Task(customer);
        return task;
    }
}
