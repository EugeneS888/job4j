package ru.job4j.stream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    List<Student> students = List.of(
            new Student(100, "Иванов"),
            new Student(90, "Петров"),
            new Student(80, "Сидоров"),
            new Student(70, "Пеле"),
            new Student(60, "Месси"),
            new Student(50, "Тихонов"),
            new Student(40, "Титов"),
            new Student(30, "Мостовой"),
            new Student(20, "Каррера"),
            new Student(10, "Карпин")
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

    @Test
    public void whenListToMapThen() {
        School school = new School();
        Map<String, Student> st = school.collectMap(students);
        Map<String, Student> st1 = new HashMap<String, Student>();
        st1.put("Иванов", new Student(100, "Иванов"));
        st1.put("Петров", new Student(90, "Петров"));
        st1.put("Сидоров", new Student(80, "Сидоров"));
        st1.put("Пеле", new Student(70, "Пеле"));
        st1.put("Месси", new Student(60, "Месси"));
        st1.put("Тихонов", new Student(50, "Тихонов"));
        st1.put("Титов", new Student(40, "Титов"));
        st1.put("Мостовой", new Student(30, "Мостовой"));
        st1.put("Каррера", new Student(20, "Каррера"));
        st1.put("Карпин", new Student(10, "Карпин"));
        st.forEach((k, v) -> System.out.println(v.getLastname()));

        assertThat(st, is(st1));
    }

    /*private static boolean compareMaps(Map<String, Object> map1, Map<String, Object> map2) {
            return map1.entrySet().containsAll(map2.entrySet()) && map2.entrySet().containsAll(map1.entrySet());
        }*/

}