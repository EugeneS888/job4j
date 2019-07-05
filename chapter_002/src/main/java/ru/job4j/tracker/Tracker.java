package ru.job4j.tracker;

import ru.job4j.models.*;

public class Tracker {
    public Item[] items = new Item[3];

    public static void main(String[] args) {
        //Item item = new Item("name", "desc", 0);
        //System.out.println(item.getName() + " " + item.getDescription());
        Tracker tracker = new Tracker();
        tracker.items[0] = new Item("name", "desc", 0l);
        tracker.items[1] = new Task("name1", "rrr2");
        tracker.items[2] = new Bug();
        //System.out.println(task.getName() + " " + task.getDescription());
        for (Item item : tracker.items) {
            if (item instanceof Task) {
                Task task=(Task) item;
                System.out.println(task.calculatePrice());
            }
            System.out.println(item.getName() + " " + item.getDescription());
        }
    }
}
