package ru.job4j.tracker;

public class FindByIdItem extends BaseAction {
    public FindByIdItem() {
        super(4, "FIND BY ID Item.");
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Найти заявку по id --------------");
        String id = input.ask("Введите id заявки :");
        Item res = tracker.findById(id);
        if (res != null) {
            System.out.println(res.getName() + " ; описание: " + res.getDecs() + "; id: " + res.getId());
            System.out.println("------------ Заявка с id : " + id + " показана -----------");
        } else {
            System.out.println("Заявки с id : " + id + " не существует! ");
        }
    }
}