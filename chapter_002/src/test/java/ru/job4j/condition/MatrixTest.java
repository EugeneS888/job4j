package ru.job4j.condition;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Matrix m = new Matrix();
        List<List<Integer>> matrix = List.of(
                List.of(3, 4, 5),
                List.of(4, 5, 6),
                List.of(5, 4)
        );
        m.setMatrix(matrix);
        Set<Integer> result = m.getCommonElements();
        Set<Integer> expected = new HashSet<>();
        expected.add(4);
        expected.add(5);
        assertThat(result, is(expected));
    }
}