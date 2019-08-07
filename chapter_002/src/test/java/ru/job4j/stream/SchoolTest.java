package ru.job4j.stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    List<Student> students = List.of(
            new Student(100),
            new Student(90),
            new Student(80),
            new Student(70),
            new Student(60),
            new Student(50),
            new Student(40),
            new Student(30),
            new Student(20),
            new Student(10)
    );

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
    public void when70to100ThenA() {
        School school = new School();
        List<Student> st = school.collect(students, student -> student.getScore() > 70);
        for (Student s : st) {
            System.out.println(s.getScore());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("100")
                                .append(System.lineSeparator())
                                .append("90")
                                .append(System.lineSeparator())
                                .append("80")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void when50to70ThenB() {
        School school = new School();
        List<Student> st = school.collect(students, student -> student.getScore() > 50 && student.getScore() <= 70);
        for (Student s : st) {
            System.out.println(s.getScore());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("70")
                                .append(System.lineSeparator())
                                .append("60")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void when0to50ThenC() {
        School school = new School();
        List<Student> st = school.collect(students, student -> student.getScore() > 0 && student.getScore() <= 50);
        for (Student s : st) {
            System.out.println(s.getScore());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("50")
                                .append(System.lineSeparator())
                                .append("40")
                                .append(System.lineSeparator())
                                .append("30")
                                .append(System.lineSeparator())
                                .append("20")
                                .append(System.lineSeparator())
                                .append("10")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

}