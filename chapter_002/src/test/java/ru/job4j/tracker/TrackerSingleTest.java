package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleTest {
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
    public void whenEnumSingletonThenNewTracker() {
        TrackerSingle tracker = TrackerSingle.INSTANCE;
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        TrackerSingle tracker1 = TrackerSingle.INSTANCE;
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker1.add(next);
        List<Item> result = tracker1.findAll();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getName());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("test1")
                                .append(System.lineSeparator())
                                .append("test2")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenPrivateConstructorSingletonThenNewTracker() {
        TrackerSingle1 tracker = TrackerSingle1.getInstance();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        TrackerSingle1 tracker1 = TrackerSingle1.getInstance();
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker1.add(next);
        List<Item> result = tracker1.findAll();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getName());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("test1")
                                .append(System.lineSeparator())
                                .append("test2")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenPrivateConstructorSingletonConstantInstanceThenNewTracker() {
        TrackerSingle2 tracker = TrackerSingle2.getInstance();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        TrackerSingle2 tracker1 = TrackerSingle2.getInstance();
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker1.add(next);
        List<Item> result = tracker1.findAll();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getName());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("test1")
                                .append(System.lineSeparator())
                                .append("test2")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenInnerClassSingletonThenNewTracker() {
        TrackerSingle3 tracker = TrackerSingle3.getInstance();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        TrackerSingle3 tracker1 = TrackerSingle3.getInstance();
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker1.add(next);
        List<Item> result = tracker1.findAll();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getName());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("test1")
                                .append(System.lineSeparator())
                                .append("test2")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenNotSingletonThenNewTracker() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Tracker tracker2 = new Tracker();
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker2.add(next);
        List<Item> result = tracker2.findAll();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getName());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("test2")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}