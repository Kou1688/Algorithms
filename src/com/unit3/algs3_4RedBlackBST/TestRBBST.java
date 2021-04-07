package com.unit3.algs3_4RedBlackBST;

import java.util.Scanner;


public class TestRBBST {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RedBlackBST<String, Integer> redBlackBST = new RedBlackBST<>();
        for (int i = 0; in.hasNext(); i++) {
            String key = in.next();
            redBlackBST.put(key, i);
        }
        System.out.println();
        System.out.println(redBlackBST.get("X"));
    }
}
