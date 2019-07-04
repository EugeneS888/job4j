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

    @Test
    public void whenMax7To5To8Then8() {
        Max max = new Max();
        int result = max.max(7, 5, 8);
        assertThat(result, is(8));
    }

    @Test
    public void whenMax8To5To3To9Then9() {
        Max max = new Max();
        int result = max.max(8, 5, 3, 9);
        assertThat(result, is(9));
    }
}