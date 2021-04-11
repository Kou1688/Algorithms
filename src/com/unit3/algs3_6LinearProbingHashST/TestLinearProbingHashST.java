package com.unit3.algs3_6LinearProbingHashST;

import java.util.Scanner;

public class TestLinearProbingHashST {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinearProbingHashST<String, Integer> linearProbingHashST = new LinearProbingHashST<>(10);
        linearProbingHashST.put(in.next(), in.nextInt());
        linearProbingHashST.put(in.next(), in.nextInt());
        linearProbingHashST.put(in.next(), in.nextInt());
        System.out.println(linearProbingHashST.get(in.next()));
        System.out.println(linearProbingHashST.size());
        linearProbingHashST.delete(in.next());
        System.out.println(linearProbingHashST.size());
        System.out.println(linearProbingHashST.keys());
    }
}
