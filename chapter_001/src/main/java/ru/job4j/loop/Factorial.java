package ru.job4j.loop;

/**
 * Вычисление факториала
 *
 * @author Eugene
 */
public class Factorial {
    /**
     * Расчет факториала
     *
     * @param n число факториала
     * @return результат вычисления (факториал n)
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}