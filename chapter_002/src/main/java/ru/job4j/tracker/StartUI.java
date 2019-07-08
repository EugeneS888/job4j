package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void findItemById() {
        System.out.println("------------ Найти заявку по id --------------");
        String id = this.input.ask("Введите id заявки :");
        Item res = this.tracker.findById(id);
        System.out.println(res.getName() + " ; описание: " + res.getDecs() + "; id: " + res.getId());
        System.out.println("------------ Заявка с Id : " + id + " показана -----------");
    }

    private void findItemByName() {
        System.out.println("------------ Найти заявку по Имени --------------");
        String name = this.input.ask("Введите Имя заявки :");
        Item[] items = this.tracker.findByName(name);
        for (Item item : items) {
            if (item != null) {
                System.out.println(item.getName() + " ; описание: " + item.getDecs() + "; id: " + item.getId());
            }
        }
        System.out.println("------------ Заявки с Именем : " + name + " показаны -----------");
    }

    private void deleteItem() {
        System.out.println("------------ Удалить заявку --------------");
        String id = this.input.ask("Введите id заявки :");
        this.tracker.delete(id);
        System.out.println("------------ Заявка с Id : " + id + " удалена -----------");
    }

    private void editItem() {
        System.out.println("------------ Редактировать заявку --------------");
        String id = this.input.ask("Введите id заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        this.tracker.findById(id).setDecs(desc);
        System.out.println("------------ Заявка с Id : " + id + " отредактирована -----------");
    }

    public void showAllItems() {
        System.out.println("------------ Список всех заявок --------------");
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            if (item != null) {
                System.out.println(item.getName() + " ; описание: " + item.getDecs() + "; id: " + item.getId());
            }
        }
        System.out.println("------------ Список закончен --------------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        // добавить остальные пункты меню.
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}