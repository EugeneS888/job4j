package ru.job4j.array;

public class TwoArrays {
    public int[] merge(int[] left, int[] right) {
        int[] c = new int[left.length + right.length];
        int j=0;
        for (int i = 0; i < c.length; i++) {
            if (left[j] < right[j]) {
                c[i]=left[j];
                c[i+1]=right[j];
                i++;
            }else{
                c[i]=right[j];
                c[i+1]=left[j];
                i++;
            }
            j++;
        }
        return c;
    }
}
