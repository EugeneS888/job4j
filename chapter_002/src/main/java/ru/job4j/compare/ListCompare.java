package ru.job4j.compare;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] symL = left.toCharArray();
        char[] symR = right.toCharArray();
        int res = 0;
        for (int i = 0; i < symL.length; i++) {
            if (symR.length > i) {
                res = Character.compare(symL[i], symR[i]);
                if (res != 0) {
                    break;
                }
            } else {
                res = 1;
                break;
            }
        }
        if (res == 0 && symL.length < symR.length) {
            res = -1;
        }
        return res;
    }
}
