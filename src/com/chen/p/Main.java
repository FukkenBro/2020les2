package com.chen.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws Exception {

        MyIntArrayList list1 = new MyIntArrayList();
        for (int i = 0; i < 20; i++) {
            list1.add(RANDOM.nextInt(100));
        }
        inspect(list1);
        list1.remove(0);
        inspect(list1);
        list1.removeByValue(10);
        inspect(list1);
        list1.bubbleSort();
        inspect(list1);
        list1 = list1.subList(5, 10);
        inspect(list1);
        list1.clear();
        inspect(list1);
        list1.remove(0);
        // :)
    }

    private static void inspect(MyIntArrayList list) {
        System.out.println("size is " + list.size());
        System.out.println("element data size is " + list.getElementData().length);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
