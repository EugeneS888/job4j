package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        for (int i = 0; i < data.length; i++) {
            if (i + 1 < data.length) {
                if (data[i][i] != data[i + 1][i + 1]) {
                    diagonal1 = false;
                    break;
                }
                if (data[i][data.length - 1 - i] != data[i + 1][data.length - i - 1 - 1]) {
                    diagonal2 = false;
                    break;
                }
            }
        }
        if (!diagonal1 || !diagonal2) {
            result = false;
        }
        return result;
    }
}