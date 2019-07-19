package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int size = list.size();
        double res = (double) size / (double) rows;
        int cells = (int) Math.ceil(res);
        int[][] array = new int[rows][cells];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (count < size) {
                    array[i][j] = list.get(count);
                } else {
                    array[i][j] = 0;
                }
                count++;
            }
        }
        return array;
    }
}