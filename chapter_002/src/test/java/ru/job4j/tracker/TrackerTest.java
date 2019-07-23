package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindByNameThenTrackerHasSameItems() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        Item item2 = new Item("test1", "testDescription", created);
        Item item3 = new Item("test2", "testDescription", created);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = tracker.findByName("test1");
        assertThat(2, is(result.size()));
    }

    @Test
    public void whenDeleteByIdItemsThenTrue() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        Item item2 = new Item("test2", "testDescription", created);
        Item item3 = new Item("test3", "testDescription", created);
        tracker.add(item);
        String id = item.getId();
        tracker.add(item2);
        tracker.add(item3);
        boolean result = tracker.delete(id);
        assertThat(true, is(result));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        //System.out.println(previous.getName());
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        //System.out.println(next.getName());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
}