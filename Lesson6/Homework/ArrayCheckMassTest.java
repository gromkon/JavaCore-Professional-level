package Lesson6.Homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayCheckMassTest {

    private ArrayCheck check;

    private boolean expected;
    private int[] arr;

    public ArrayCheckMassTest(boolean expected, int[] arr) {
        this.expected = expected;
        this.arr = arr;
    }

    @Before
    public void init() {
        check = new ArrayCheck();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                    {true, new int[]{1, 1, 1, 4, 4, 1, 4, 4}},
                    {false, new int[]{1, 1, 1, 1, 1, 1}},
                    {false, new int[]{4, 4, 4, 4}},
                    {false, new int[]{1, 4, 4, 1, 1, 4, 3}},
                }
        );
    }

    @Test
    public void massTest() {
        Assert.assertEquals(expected, check.check(arr));
    }

}
