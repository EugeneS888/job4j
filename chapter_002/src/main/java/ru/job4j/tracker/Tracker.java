package ru.job4j.tracker;

import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    private static final Random RN = new Random();
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int i = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[i] = item;
                i++;
            }
        }
        //Arrays.copyOf(luckyNumbers, luckyNumbers.length);
        Item[] res = new Item[i];
        System.arraycopy(result, 0, res, 0, i);
        return res;
    }

    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = true;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                System.out.println("items[" + i + "] :" + items[i]);
                System.out.println("items[" + (i + 1) + "] :" + items[i + 1]);
                System.out.println("items[" + (i + 2) + "] :" + items[i + 2]);
                System.out.println("items[" + (i + 3) + "] :" + items[i + 3]);
                System.out.println("items[" + (i + 4) + "] :" + items[i + 4]);
                System.out.println("items[" + (i + 5) + "] :" + items[i + 5]);
                if (!items[i].getId().equals(id)) {
                    result = true;
                    this.position--;
                }
                break;
            }
        }
        return result;
    }
}