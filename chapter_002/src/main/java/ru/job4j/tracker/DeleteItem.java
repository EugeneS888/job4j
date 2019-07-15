package ru.job4j.tracker;

public class DeleteItem extends BaseAction {
    public DeleteItem() {
        super(3, "DELETE Item.");
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
}