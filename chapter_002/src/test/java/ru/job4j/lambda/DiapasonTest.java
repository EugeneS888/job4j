package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(3, 6, x -> Math.pow(x, 2) - x - 2);
        List<Double> expected = Arrays.asList(4D, 10D, 18D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenNaturalLogarithmicFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(1, 3, x -> Math.log(x));
        List<Double> expected = Arrays.asList(0D, 0.6931471805599453D);
        assertThat(result, is(expected));
    }
}