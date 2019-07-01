package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax5To3Then5() {
        Max max = new Max();
        int result = max.max(5, 3);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax7To7Then7() {
        Max max = new Max();
        int result = max.max(7, 7);
        assertThat(result, is(7));
    }
}