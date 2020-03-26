package Lesson1.Homework;

public class Task1 {

    public static <T> void swap(T[] arr, int ind1, int ind2) {
        T elem = arr[ind2];
        arr[ind2] = arr[ind1];
        arr[ind1] = elem;
    }

    public static <T> void showArray(T[] arr) {
        for (T elem : arr) {
            System.out.print(elem + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] arrInt = new Integer[]{1, 2, 3, 4, 5};
        showArray(arrInt);
        swap(arrInt, 1, 3);
        System.out.println();
        showArray(arrInt);

        System.out.println();
        System.out.println();

        String[] arrStr = new String[]{"a", "b", "c", "d", "e"};
        showArray(arrStr);
        swap(arrStr, 0, 1);
        System.out.println();
        showArray(arrStr);
    }

}
