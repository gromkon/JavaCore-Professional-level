package Lesson6.Homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArraySliceTest {

    private ArraySlice as;

    @Before
    public void init() {
        as = new ArraySlice();
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(
                new int[]{1, 2},
                as.cut(new int[]{5, 6, 1, 2, 4, 1, 2, 4, 1, 2})
        );
    }

    @Test(expected = RuntimeException.class)
    public void test2() {
        Assert.assertArrayEquals(
                new int[]{1, 2},
                as.cut(new int[]{1, 1, 1})
        );
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(
                new int[]{5, 6, 7},
                as.cut(new int[]{1, 2, 3, 4, 5, 6, 7})
        );
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(
                new int[]{5, 6, 7},
                as.cut(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
        );
    }

}
