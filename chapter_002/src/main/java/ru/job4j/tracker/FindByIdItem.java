package ru.job4j.tracker;

public class FindByIdItem implements UserAction {
    private static final int FIND_BY_ID = 4;

    @Override
    public int key() {
        return FIND_BY_ID;
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

    @Override
    public String info() {
        return "4. FIND BY ID Item.";
    }
}