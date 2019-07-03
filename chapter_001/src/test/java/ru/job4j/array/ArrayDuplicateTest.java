package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] expectedArr = new String[]{"Привет", "Мир", "Супер"};
        String[] resultArr = duplicate.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        assertThat(resultArr, is(expectedArr));
    }

    @Test
    public void whenRemoveDuplicatesOfSevenPiesesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] expectedArr = new String[]{"Привет", "Мир", "Супер", "Труд", "Май"};
        String[] resultArr = duplicate.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир", "Труд", "Май"});
        assertThat(resultArr, arrayContainingInAnyOrder(expectedArr));
    }
}

