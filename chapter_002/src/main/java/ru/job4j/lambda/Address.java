package ru.job4j.lambda;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    public String getCity() {
        return city;
    }

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

}
