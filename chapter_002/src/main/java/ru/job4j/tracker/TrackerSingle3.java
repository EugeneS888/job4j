package ru.job4j.tracker;

import java.util.ArrayList;

public class TrackerSingle3 {

    private TrackerSingle3() {
    }

    public static TrackerSingle3 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
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
