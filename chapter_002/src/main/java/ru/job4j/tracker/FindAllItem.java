package ru.job4j.tracker;

public class FindAllItem implements UserAction {
    private static final int SHOW_ALL = 1;

    @Override
    public int key() {
        return SHOW_ALL;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Список всех заявок --------------");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            if (item != null) {
                System.out.println(item.getName() + " ; описание: " + item.getDecs() + "; id: " + item.getId());
            }
        }
        System.out.println("------------ Список закончен --------------");
    }

    @Override
    public String info() {
        return "1. SHOW ALL Items.";
    }
}