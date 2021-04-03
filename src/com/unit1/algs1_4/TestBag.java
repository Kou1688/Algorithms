package com.unit1.algs1_4;

import java.util.Scanner;

/**
 * Bag的测试用例
 */
public class TestBag {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Bag<String> bag = new Bag<>();
        while (reader.hasNext()) {
            String item = reader.nextLine();
            bag.add(item);
        }
        System.out.println("背包大小:" + bag.size());
        for (String s : bag) {
            System.out.println(s);
        }
    }
}
