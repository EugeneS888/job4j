package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public List<Integer> convert(List<int[]> list) {
        List<Integer> res = new ArrayList<>();
        for (int[] listArr : list) {
            for (int l : listArr) {
                res.add(l);
            }
        }
        return res;
    }
}
