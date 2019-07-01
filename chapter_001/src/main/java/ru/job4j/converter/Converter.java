package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public double rubleToEuro(int value) {
        double koeff = 70d;
        return (double) value / koeff;
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары
     */
    public double rubleToDollar(int value) {
        double koeff = 60d;
        return (double) value / koeff;
    }

    /**
     * Конвертируем евро в рубли.
     *
     * @param value евро.
     * @return рубли.
     */
    public double euroToRuble(int value) {
        double koeff = 70d;
        return (double) koeff * value;
    }

    /**
     * Конвертируем доллары в рубли.
     *
     * @param value доллары.
     * @return рубли.
     */
    public double dollarToRuble(int value) {
        double koeff = 60d;
        return (double) koeff * value;
    }
}