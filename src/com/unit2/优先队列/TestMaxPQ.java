package com.unit2.优先队列;

import java.util.Scanner;

public class TestMaxPQ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 10;
        MaxPQ<Integer> pq = new MaxPQ<Integer>(N);
        Comparable[] arr = new Comparable[N];
        for (int i = 0; i < N; i++) {
            pq.insert(in.nextInt());
        }
        /*for (int i = 0; i < N; i++) {
            arr[i] = pq.delMax();
        }*/
        //pq.sort(arr);
        /*for (Comparable i : arr) {
            System.out.print(i + " ");
        }*/
    }
}
