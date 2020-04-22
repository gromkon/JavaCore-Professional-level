package Lesson6.Homework;

import java.util.Arrays;

public class ArraySlice {

    public int[] cut(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 4) {
                return Arrays.copyOfRange(a, i + 1, a.length);
            }
        }
        throw new RuntimeException();
    }

}
