package com.gb.lesson1.partOneAndTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Object [] name = {"Петя", "Вася", "Коля", "Алекс"};

        int value = (int)(Math.random() * name.length);
        int value2 = 0;
        boolean check = false;

        while (!check){
            value2 = (int)(Math.random() * name.length);
            if (value2 != value){
                break;
            } else {
                check = false;
            }
        }

        System.out.println("Задание 1: " + "\n" +
                "Исходный массив: " + Arrays.toString(name));
        System.out.println("Индекс 1 = " + value + "\n" +
                "Индекс 2 = " + value2);
        array(name, value, value2);

        System.out.println();

        System.out.println("Задание 2:");
        System.out.println(arrayList(name));
    }

//    Задача 1 - метод, который меняет два элемента массива местами
    public static void array(Object[] array, int a, int b){
        Object[] objects = array.clone();

        objects[a] = array[b];
        objects[b] = array[a];

        System.out.println(Arrays.toString(objects));
    }

//    Задача 2 - метод, который преобразует массив в ArrayList;
    public static <E> ArrayList<E> arrayList(E[] array){
        return new ArrayList<> (Arrays.asList(array));
    }
}