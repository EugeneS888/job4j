package ru.job4j.stream;

import java.util.Objects;

public class Student {
    private int score;
    private String lastname;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score && Objects.equals(lastname, student.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, lastname);
    }

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
