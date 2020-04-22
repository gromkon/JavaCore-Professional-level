package Lesson6.OnLesson;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalcMassAddTest {

    private int a;
    private int b;
    private int answer;

    private Calculator calculator;

    public CalcMassAddTest(int a, int b, int answer) {
        this.a = a;
        this.b = b;
        this.answer = answer;
    }

    @Before
    public void init() {
        System.out.println("Тест начат");
        calculator = new Calculator();
    }

    @After
    public void shutdown() {
        System.out.println("Тест завершен");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0, 0},
                {1, 1, 2},
                {1, 1, 5}
            }
        );
    }

    @Test
    public void massTest() {
        Assert.assertEquals(answer, calculator.add(a, b));
    }
}
