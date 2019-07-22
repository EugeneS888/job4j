package ru.job4j.tracker;

import java.util.ArrayList;

public class FindAllItem extends BaseAction {
    public FindAllItem() {
        super(1, "SHOW ALL Items.");
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Список всех заявок --------------");
        ArrayList<Item> items = tracker.findAll();
        for (Item item : items) {
            if (item != null) {
                System.out.println(item.getName() + " ; описание: " + item.getDecs() + "; id: " + item.getId());
            }
        }
        System.out.println("------------ Список закончен --------------");
    }
}