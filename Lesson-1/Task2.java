package Lesson1.Homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    public static <T> ArrayList<T> toArrayList(T[] mas) {
        return new ArrayList<>(Arrays.asList(mas));
    }

    public static void main(String[] args) {
        Integer[] arrInt = new Integer[]{1, 2, 3, 4, 5};
        ArrayList<Integer> alInt = toArrayList(arrInt);
        System.out.println(alInt);

        String[] arrStr = new String[]{"a", "b", "c", "d", "e"};
        ArrayList<String> alStr = toArrayList(arrStr);
        System.out.println(alStr);

    }
}
