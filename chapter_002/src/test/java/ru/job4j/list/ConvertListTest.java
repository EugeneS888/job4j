package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {

    @Test
    public void when7ElementsThen9() {
        ConvertList list = new ConvertList();
        List<int[]> res = new ArrayList<>();
        List<Integer> expect = new ArrayList<>();
        res.add(new int[]{1, 2});
        res.add(new int[]{3, 4});
        List<Integer> result = list.convert(res);
        expect.add(1);
        expect.add(2);
        expect.add(3);
        expect.add(4);
        assertThat(result, is(expect));
    }
}
