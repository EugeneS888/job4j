package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        int count = tasks.size();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                if (tasks.get(i).getPriority() > task.getPriority()) {
                    tasks.set(i, task);
                } else {
                    tasks.addLast(task);
                }
            }
        } else {
            tasks.add(0, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}