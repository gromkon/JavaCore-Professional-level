package Lesson7.Homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Tester {
    public static void start(Class testClass) throws Exception {

        Object ts = testClass.getConstructor().newInstance();

        Method[] methods = testClass.getDeclaredMethods();

        int bsCount = 0;
        int asCount = 0;

        Method bs = null;
        Method as = null;

        HashMap<Method, Integer> methodMap = new HashMap<>();

        for (Method m: methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (bsCount == 0) {
                    bs = m;
                    bsCount++;
                } else {
                    throw new RuntimeException();
                }
            } else if (m.isAnnotationPresent(AfterSuite.class)) {
                if (asCount == 0) {
                    asCount++;
                    as = m;
                } else {
                    throw new RuntimeException();
                }
            } else if (m.isAnnotationPresent(Test.class)) {
                methodMap.put(m, m.getAnnotation(Test.class).priority());
            }
        }

        if (bs != null) {
            bs.invoke(ts);
        }

        methodMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(mp -> {
                    try {
                        mp.getKey().invoke(ts);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });

        if (as != null) {
            as.invoke(ts);
        }

    }

    public static void main(String[] args) {
        try {
            start(TestClass.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
