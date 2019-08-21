package ru.job4j.condition;

import java.util.*;

public class Matrix {

    private List<List<Integer>> matrix;

    public void setMatrix(List<List<Integer>> matrix) {
        this.matrix = matrix;
    }

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
}
