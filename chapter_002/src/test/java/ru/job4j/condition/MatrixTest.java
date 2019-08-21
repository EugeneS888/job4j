package ru.job4j.condition;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Matrix m = new Matrix();
        Set<Integer> result = m.getCommonElements();
        Set<Integer> expected = new HashSet<>();
        expected.add(2);
        expected.add(3);
        assertThat(result, is(expected));
    }
}