package ru.job4j.tracker;

public class FindByNameItem extends BaseAction {
    public FindByNameItem() {
        super(5, "FIND BY NAME Items.");
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Найти заявку по Имени --------------");
        String name = input.ask("Введите Имя заявки :");
        Item[] items = tracker.findByName(name);
        for (Item item : items) {
            if (item != null) {
                System.out.println(item.getName() + " ; описание: " + item.getDecs() + "; id: " + item.getId());
            }
        }
        if (items.length > 0) {
            System.out.println("Заявки с Именем : " + name + " показаны ");
        } else {
            System.out.println("Заявки с Именем : " + name + " не найдены! ");
        }
    }
}