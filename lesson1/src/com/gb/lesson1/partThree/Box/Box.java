package com.gb.lesson1.partThree.Box;

import com.gb.lesson1.partThree.Fruits.Applle;
import com.gb.lesson1.partThree.Fruits.Citrus;
import com.gb.lesson1.partThree.Fruits.Lemons;
import com.gb.lesson1.partThree.Fruits.Orange;

import java.util.ArrayList;
import java.util.List;


public class Box {

//    Создаём переменные
    public static final float WEIGHT_APPLE = 1.0f;
    public static final float WEIGHT_ORANGE = 1.5f;

    static ArrayList<Applle> apples = new ArrayList<>();
    static List<Citrus> orange = new ArrayList<>();
    static List<Citrus> lemons = new ArrayList<>();

//    Содержим не цитрус
    public static float thisIsNotCitrus() {
//        Создаём яблоки
        apples.add(new Applle());
        apples.add(new Applle());
//        Возвращаем результат
        return apples.size() * WEIGHT_APPLE;
    }


    public static float thisIsCitrus() {

        orange.add(new Orange());
        lemons.add(new Lemons());


        return (orange.size() * WEIGHT_ORANGE) + (lemons.size() * WEIGHT_ORANGE);
    }


    public static void getWeight() {
        float wtCitrus = thisIsCitrus();
        float wtApple = thisIsNotCitrus();


        System.out.println("Яблоки весят: " + wtApple + " килограмма/ов");
        System.out.println("Цитрусовые фрукты весят: " + wtCitrus + " килограмма/ов");
    }


    public static boolean compare() {
        return (Math.abs(thisIsCitrus() - (thisIsNotCitrus())) < 0.0001);
    }


    public static int sprinkle() {

        List<Citrus> pannier1 = new ArrayList<>(orange);
//        List<Citrus> pannier2 = new ArrayList<>(lemons);

        orange.clear();
//        lemons.clear();

        return (pannier1.size() / 2);
    }
}
