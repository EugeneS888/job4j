package ru.job4j.inheritance;

public class Doctor extends Profession {
    public long workTime;

    public Diagnose heal(Pacient pacient) {
        Diagnose diagnose = new Diagnose(pacient);
        return diagnose;
    }
}
