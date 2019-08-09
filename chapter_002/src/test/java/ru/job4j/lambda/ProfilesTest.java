package ru.job4j.lambda;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenProfilesListThenAdressesList() {
        Profile p1 = new Profile();
        Profile p2 = new Profile();
        Profile p3 = new Profile();
        Profile p4 = new Profile();
        p1.setAddress(new Address("Moscow", "Kremlin", 1, 1));
        p2.setAddress(new Address("Moscow", "Kremlin", 2, 2));
        p3.setAddress(new Address("Moscow", "Kremlin", 2, 2));
        p4.setAddress(new Address("Spb", "Kremlin", 1, 1));
        Profiles profiles = new Profiles();
        List<Address> adr = profiles.collect(List.of(p4, p2, p3, p1));
        for (Address a : adr) {
            System.out.println(a.getCity() + "; " + a.getStreet() + "; " + a.getHome() + "; " + a.getApartment());
        }
        //assertEquals();
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("Moscow; Kremlin; 2; 2")
                                .append(System.lineSeparator())
                                .append("Moscow; Kremlin; 1; 1")
                                .append(System.lineSeparator())
                                .append("Spb; Kremlin; 1; 1")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}