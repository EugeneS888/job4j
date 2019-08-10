package ru.job4j.stream;

public class Student {
    private int score;
    private String lastname;

    Student(int score, String lastname) {
        this.score = score;
        this.lastname = lastname;
    }

    public int getScore() {
        return score;
    }

    public String getLastname() {
        return lastname;
    }
}
