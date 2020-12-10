package com.gb.lesson1.partThree;

import com.gb.lesson1.partThree.Box.Box;

public class Main {
    public static void main(String[] args){

        Box.getWeight();

        System.out.println(Box.compare());

        System.out.println("Из корзины пересыпали " + Box.sprinkle()+ " фрукт/ов");
    }
}
