package ru.job4j.array;

public class Square {
    /**
     * заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
     * @param bound
     * @return массив
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = (int) Math.pow(i, 2);
        }
        return rst;
    }
}