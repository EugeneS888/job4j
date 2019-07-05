package ru.job4j.inheritance;

public class Dentist extends Doctor {
    public String[] skills = {"Удалять", "Пломбировать"};

    public String[] getSkills() {
        return skills;
    }
}
