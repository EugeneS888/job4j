package ru.job4j.condition;

public class Max {
    public int max(int left, int right) {
        return left > right ? left : right;
    }

    public int max(int one, int two, int three) {
        return max(one, max(two, three));
    }

    public int max(int one, int two, int three, int four) {
        return max(one, max(two, three, four));
    }
}