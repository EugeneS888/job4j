package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length; i++) {
            if (i + 1 < data.length) {
                if (data[i] != data[i + 1]) {
                    return result;
                }
            }
        }
        return true;
    }
}