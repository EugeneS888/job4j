package ru.job4j.tracker;

public class UpdateItem extends BaseAction {
    public UpdateItem() {
        super(2, "Update Item.");
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактировать заявку --------------");
        String id = input.ask("Введите id заявки которую нужно изменить :");
        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        boolean res = tracker.replace(id, item);
        if (res) {
            System.out.println("------------ Заявка с Id : " + id + " отредактирована -----------");
        } else {
            System.out.println("Заявки с id : " + id + " не существует! ");
        }
    }
}