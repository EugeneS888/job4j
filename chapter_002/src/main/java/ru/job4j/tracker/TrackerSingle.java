package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum TrackerSingle {
    INSTANCE; // здесь мы указываем перечисления.

    private Tracker tracker = new Tracker();

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(String id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return tracker.delete(id);
    }
}
