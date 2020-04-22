package Lesson6.OnLesson;
import org.junit.*;

public class CalcTest {

    Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

//    @After
//    public void shutdown() {
//        System.out.println("Каклькулятор завершил работу");
//    }

    @Test
    public void testAdd1() {
        Assert.assertEquals(8, calculator.add(4, 4));
    }

    @Test
    public void testAdd2() {
        Assert.assertEquals(14, calculator.add(5, 9));
    }

    @Test
    public void testAdd3() {
        Assert.assertEquals(7, calculator.add(3, 4));
    }

    @Test
    public void testDiv1() {
        Assert.assertEquals(5, calculator.div(25, 5));
    }

    @Test(expected = ArithmeticException.class)
    @Ignore(value = "Проверил 11.04 в 14.29")
    public void testDiv2() {
        Assert.assertEquals(5, calculator.div(1, 0));
    }

    @Test(timeout = 10)
    public void testDiv3() {
        Assert.assertEquals(2, calculator.div(4, 2));
    }

}
