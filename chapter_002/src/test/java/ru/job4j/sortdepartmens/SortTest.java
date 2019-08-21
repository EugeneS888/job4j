package ru.job4j.sortdepartmens;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortTest {
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
    public void whenSortAscending() {
        Sort sort = new Sort();
        String[] departments = new String[]{"K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2"};
        sort.setDepartments(departments);
        sort.checkDepartments();
        sort.sortAscending();
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("Сортировка по возрастанию")
                                .append(System.lineSeparator())
                                .append("K1")
                                .append(System.lineSeparator())
                                .append("K1\\SK1")
                                .append(System.lineSeparator())
                                .append("K1\\SK1\\SSK1")
                                .append(System.lineSeparator())
                                .append("K1\\SK1\\SSK2")
                                .append(System.lineSeparator())
                                .append("K1\\SK2")
                                .append(System.lineSeparator())
                                .append("K2")
                                .append(System.lineSeparator())
                                .append("K2\\SK1")
                                .append(System.lineSeparator())
                                .append("K2\\SK1\\SSK1")
                                .append(System.lineSeparator())
                                .append("K2\\SK1\\SSK2")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenSortDescending() {
        Sort sort = new Sort();
        String[] departments = new String[]{"K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2"};
        sort.setDepartments(departments);
        sort.checkDepartments();
        sort.sortDescending();
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("Сортировка по убыванию")
                                .append(System.lineSeparator())
                                .append("K2\\SK1\\SSK2")
                                .append(System.lineSeparator())
                                .append("K2\\SK1\\SSK1")
                                .append(System.lineSeparator())
                                .append("K2\\SK1")
                                .append(System.lineSeparator())
                                .append("K2")
                                .append(System.lineSeparator())
                                .append("K1\\SK2")
                                .append(System.lineSeparator())
                                .append("K1\\SK1\\SSK2")
                                .append(System.lineSeparator())
                                .append("K1\\SK1\\SSK1")
                                .append(System.lineSeparator())
                                .append("K1\\SK1")
                                .append(System.lineSeparator())
                                .append("K1")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}