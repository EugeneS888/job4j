package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    public String[] skills = {"Резать", "Кромсать", "Зашивать"};

    public String[] getSkills() {
        return skills;
    }
}
