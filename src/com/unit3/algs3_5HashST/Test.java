package com.unit3.algs3_5HashST;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SeparateChainingHashST<Integer, String> hashST = new SeparateChainingHashST<>();
        for (int i = 0; i < 4; i++) {
            hashST.put(in.nextInt(), in.next());
        }
        hashST.delete(in.nextInt());
        System.out.println(hashST.get(in.nextInt()));
        System.out.println(hashST.size());
        System.out.println(hashST.keys());
    }
}
