package ru.job4j.hotels;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HotelsTest {
    @Test
    public void when5ElementsThenRange() {
        Validate validateInput = new Validate();
        validateInput.isTrueNumHotels("5");
        validateInput.isTrueRate("99 2 100 50 1");
        String result = "";
        String expect = "4 2 5 3 1 ";
        for (Map.Entry<Integer, Integer> entry : validateInput.getStars().entrySet()) {
            result = result.concat(entry.getValue() + " ");
        }
        assertThat(result, is(expect));
    }

    @Test
    public void when10ElementsThenRange() {
        Validate validateInput = new Validate();
        validateInput.isTrueNumHotels("10");
        validateInput.isTrueRate("100 90 10 20 50 60 40 30 80 70");
        String result = "";
        String expect = "5 5 1 1 3 3 2 2 4 4 ";
        for (Map.Entry<Integer, Integer> entry : validateInput.getStars().entrySet()) {
            result = result.concat(entry.getValue() + " ");
        }
        assertThat(result, is(expect));
    }
}