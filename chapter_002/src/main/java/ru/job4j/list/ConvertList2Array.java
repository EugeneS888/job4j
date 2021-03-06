package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int size = list.size();
        double res = (double) size / (double) rows;
        int cells = (int) Math.ceil(res);
        int[][] array = new int[rows][cells];
        int count = 0;
        int i = 0;
        int j = 0;
        for (int[] item : array) {
            for (int it : item) {
                if (count < size) {
                    array[i][j] = list.get(count);
                }
                j++;
                count++;
            }
            i++;
            j = 0;
        }
        return array;
    }
}