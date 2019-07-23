package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();
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
        this.items.add(this.position++, item);
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
        for (int i = 0; i < this.position; i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                result = items.get(i);
                break;
            }
        }
        return result;
    }

    public List<Item> findByName(String key) {
        //Item[] result = new Item[this.position];
        List<Item> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < this.position; i++) {
            if (items.get(i) != null && items.get(i).getName().equals(key)) {
                result.add(items.get(i));
                j++;
            }
        }
        //Arrays.copyOf(luckyNumbers, luckyNumbers.length);
        //Item[] res = new Item[j];
        //System.arraycopy(result, 0, res, 0, j);
        return result;
    }

    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        //System.arraycopy(this.items, 0, result, 0, this.position);//Этот же результат что и цикл
        for (int i = 0; i < this.position; i++) {
            result.add(items.get(i));
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = true;
        for (int i = 0; i < this.position; i++) {
            if (items.get(i).getId().equals(id)) {
                items.set(i, item);
                items.get(i).setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (items.get(i).getId().equals(id)) {
                //System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                //if (items.get(i) == null || !items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                this.position--;
                //}
                break;
            }
        }
        return result;
    }
}