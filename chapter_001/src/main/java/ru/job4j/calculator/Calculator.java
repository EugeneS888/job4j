package ru.job4j.calculator;

/**
 * Простой калькулятор.
 *
 * @author Eugene
 */
public class Calculator {
    /**
     * Сложение двух чисел.
     *
     * @param first  первое
     * @param second второе
     * @return сумма
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * Разность двух чисел.
     *
     * @param first  первое
     * @param second второе
     * @return разность
     */
    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     * Деление двух чисел.
     *
     * @param first  первое
     * @param second второе
     * @return частное
     */
    public double div(double first, double second) {
        return first / second;
    }

    /**
     * Умножение двух чисел
     *
     * @param first  первое
     * @param second второе
     * @return произведение
     */
    public double multiple(double first, double second) {
        return first * second;
    }
}
