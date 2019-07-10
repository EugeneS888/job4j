package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private static final int DELETE = 3;

    @Override
    public int key() {
        return DELETE;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удалить заявку --------------");
        String id = input.ask("Введите id заявки :");
        boolean res = tracker.delete(id);
        if (res) {
            System.out.println("Заявка с Id : " + id + " удалена ");
        } else {
            System.out.println(" Заявка с Id : " + id + " не удалена! ");
        }
    }

    @Override
    public String info() {
        return "3. DELETE Item.";
    }
}