package ru.job4j.tracker;

import java.util.ArrayList;

public class TrackerSingle1 {
    private static TrackerSingle1 instance;

    private TrackerSingle1() {
    }

    public static TrackerSingle1 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle1();
        }
        return instance;
    }

    private Tracker tracker = new Tracker();

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(String id) {
        return tracker.findById(id);
    }

    public ArrayList<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public ArrayList<Item> findAll() {
        return tracker.findAll();
    }

    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return tracker.delete(id);
    }
}