package ru.job4j.condition;

/**
 * Выбор максимального из 3-х чисел.
 *
 * @author Eugene
 */
public class MultiMax {
    /**
     * Выбор максимальго числа.
     *
     * @param first  первое
     * @param second второе
     * @param third  мтретье
     * @return максимальное
     */
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        result = result > third ? result : third;
        return result;
    }
}