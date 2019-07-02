package ru.job4j.array;

/**
 * Сортировка массива пузырьковым методом.
 *
 * @author Eugene
 */
public class BubbleSort {
    /**
     * Сортировка.
     *
     * @param array int одномерный массив
     * @return отсортированый массив
     */
    public int[] sort(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j + 1 < array.length) {
                    if (array[j] > array[j + 1]) {
                        tmp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;
                    }
                }
            }
        }
        return array;
    }
}
