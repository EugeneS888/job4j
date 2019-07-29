package ru.job4j.compare;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] symL = left.toCharArray();
        char[] symR = right.toCharArray();
        int res = 0;
        int minLenght = symL.length < symR.length ? symL.length : symR.length;
        for (int i = 0; i < minLenght; i++) {
            res = Character.compare(symL[i], symR[i]);
            if (res != 0) {
                break;
            }
        }
        if (res == 0 && symL.length != symR.length) {
            res = symL.length < symR.length ? -1 : 1;
        }
        return res;
    }
}
