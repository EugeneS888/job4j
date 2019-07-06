package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TwoArraysTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        int[] a = new int[] {1, 3};
        int[] b = new int[] {2, 4};
        TwoArrays bubble = new TwoArrays();
        int[] expectedArr = new int[]{1, 2, 3, 4};
        int[] resultArr = bubble.merge(a,b);
        assertThat(resultArr, is(expectedArr));
    }
}