package ru.job4j.array;

import java.util.Arrays;

/**
 * Удаление дубликатов из массива
 *
 * @author Eugene
 */
public class ArrayDuplicate {
    /**
     * Удаление дубликатов из строкового массива
     *
     * @param array строковый массив
     * @return очищеный массив
     */
    public String[] remove(String[] array) {
        String tmp = "";
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - counter; j++) {
                if (array[i].equals(array[j])) {
                    tmp = array[j];
                    array[j] = array[array.length - i - 1];
                    array[array.length - i - 1] = tmp;
                    j++;
                    counter++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - counter);
    }
}
