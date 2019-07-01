package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubtractOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        double res = calc.subtract(5d, 2d);
        double expected = 3d;
        assertThat(res, is(expected));
    }

    @Test
    public void whenDivOneDivisionOneThenOne() {
        Calculator calc = new Calculator();
        double res = calc.div(8d, 4d);
        double expected = 2d;
        assertThat(res, is(expected));
    }

    @Test
    public void whenMultipleOneMultiplyOneThenOne() {
        Calculator calc = new Calculator();
        double res = calc.multiple(2d, 2d);
        double expected = 4d;
        assertThat(res, is(expected));
    }
}