package ru.job4j.condition;

/**
 * Рассчет площади прямоугольника.
 *
 * @author Eugene
 */
public class SqArea {
    /**
     * Вычисление площади прямоугольника.
     *
     * @param p периметр прямоугольника
     * @param k отношение ширины прямоугольника к его высоте
     * @return площадь прямоугольника
     */
    public int square(int p, int k) {
        int h = (p / 2) / (k + 1);
        int w = h * k;
        return w * h;
    }
}