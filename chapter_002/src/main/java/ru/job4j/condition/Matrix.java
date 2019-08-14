package ru.job4j.condition;

import java.util.*;

public class Matrix {
    private List<List<Integer>> matrix = List.of(
            List.of(1, 2, 3),
            List.of(2, 3, 4),
            List.of(2, 3)
    );

    public Set<Integer> getCommonElements() {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (List<Integer> matx : matrix) {
            for (Integer m : matx) {
                if (!set1.add(m)) {
                    set.add(m);
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        Matrix m = new Matrix();
        for (Integer list : m.getCommonElements()) {
            System.out.println(list);
        }
    }
}
