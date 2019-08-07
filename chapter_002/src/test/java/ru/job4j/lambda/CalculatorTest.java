package ru.job4j.lambda;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        /*List<String> names = Arrays.asList("Petr", "Nick", "Ban");
        String last = null;
        names.forEach(
                n -> last = n
        );*/
        calc.multiple(
                0, 3, 1,
                (value, index) -> (double) value + index,
                result1 -> buffer.add(result1)
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
}