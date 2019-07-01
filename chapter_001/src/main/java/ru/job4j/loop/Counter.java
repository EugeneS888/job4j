package ru.job4j.loop;

/**
 * Счетчик.
 *
 * @author Eugene
 */
public class Counter {
    /**
     * Сумма четных чисел в диапазоне
     *
     * @param start  начало диапазона
     * @param finish конец диапазона
     * @return сумма
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}