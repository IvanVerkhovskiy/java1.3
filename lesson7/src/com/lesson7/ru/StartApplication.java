package com.lesson7.ru;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class StartApplication {

    public static int Count1 = 0;
    public static int Count2 = 0;

    public static void main(String[] args) throws Exception {

        start(TestOne.class);
        start(TestTwo.class);

    }

    public static void start(Class classing) throws Exception {
        Method[] method = classing.getDeclaredMethods();
        Set<Integer> pSet = new HashSet<>();

        check(method);
        before(method);
        test(method, pSet);
        after(method);
    }

    private static void check(Method[] methods) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                Count1++;
                if (Count1 > 1) {
                    throw new RuntimeException("@BeforeSuite есть");
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                Count2++;
                if (Count2 > 1) {
                    throw new RuntimeException("@AfterSuite есть!");
                }
            }
        }
    }

    private static void before(Method[] methods) throws IllegalAccessException, InvocationTargetException {
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.invoke(null);
            }
        }
    }

    private static void test(Method[] methods, Set<Integer> prioritySet) throws Exception {
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {

                prioritySet.add(method.getAnnotation(Test.class).priority());
            }
        }
        List<Integer> priorityList = new ArrayList<>(prioritySet);
        Collections.sort(priorityList);

        for (int i = 0; i < priorityList.size(); i++) {

            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    if (priorityList.get(i) == method.getAnnotation(Test.class).priority()) {
                        method.invoke(null);
                    }
                }
            }
        }
    }

    private static void after(Method[] methods) throws IllegalAccessException, InvocationTargetException {
        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class))
            {
                method.invoke(null);
                Count2++;
                if (Count2 > 1) {
                    throw new RuntimeException("@AfterSuite есть!");
                }
            }
        }
    }

}