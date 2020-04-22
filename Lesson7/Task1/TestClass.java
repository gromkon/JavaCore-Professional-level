package Lesson7.Homework;

public class TestClass {

    @BeforeSuite
    public void hello() {
        System.out.println("start");
    }

    @AfterSuite
    public void end() {
        System.out.println("end");
    }

    @Test(priority = 6)
    public void test1() {
        System.out.println("test1");
    }

    @Test(priority = 9)
    public void test2() {
        System.out.println("test2");
    }

    @Test(priority = 6)
    public void test3() {
        System.out.println("test3");
    }

    @Test(priority = 4)
    public void test4() {
        System.out.println("test4");
    }

    @Test(priority = 6)
    public void test5() {
        System.out.println("test5");
    }

    @Test(priority = 12)
    public void test6() {
        System.out.println("test6");
    }
}
