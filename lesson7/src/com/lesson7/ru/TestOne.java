package com.lesson7.ru;

public class TestOne {
    @BeforeSuite(description = "Запуск теста")
    public static void beforeTesting() {
        System.out.println("Новогодний стих!");
    }

    @Test(description = "1", priority = 1)
    public static void test1() {
        System.out.println("Пусть отзовется искоркой тепла,");
    }

    @Test(description = "2", priority = 2)
    public static void test2() {
        System.out.println("Этот праздник славный в сердце каждом,");
    }

    @Test(description = "3", priority = 3)
    public static void test3() {
        System.out.println("Так, чтоб душа от счастья расцвела,");
    }

    @Test(description = "4", priority = 4)
    public static void test4() {
        System.out.println("И чтобы сказкой стала жизнь однажды!");
    }

    @Test(description = "5", priority = 5)
    public static void test5() {
        System.out.println("Он воплотит заветные мечты,");
    }

    @Test(description = "6", priority = 6)
    public static void test6() {
        System.out.println("Самые прекрасные и смелые надежды,");
    }

    @Test(description = "8", priority = 8)
    public static void test8() {
        System.out.println("В этот праздник зимний, белоснежный!");
    }

    @Test(description = "7", priority = 7)
    public static void test7() {
        System.out.println("И в мире станет больше доброты.");
    }

    @AfterSuite(description = "close")
    public static void afterTesting() {
        System.out.println("С новым годом!!!");
    }
}