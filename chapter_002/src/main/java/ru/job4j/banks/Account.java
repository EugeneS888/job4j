package ru.job4j.banks;

public class Account {

    private double value;
    private long requisites;

    public Account() {
    }

    public Account(double value, long requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public long getRequisites() {
        return requisites;
    }


    public void setValue(double value) {
        this.value = value;
    }

}
