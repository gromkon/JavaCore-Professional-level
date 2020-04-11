package Lesson6.Homework;

public class ArrayCheck {

    public boolean check(int[] a) {
        boolean one = false;
        boolean four = false;
        for (int elem: a) {
            if (elem == 1) {
                one = true;
            } else if (elem == 4) {
                four = true;
            } else {
                return false;
            }
        }
        return one && four;
    }

}
