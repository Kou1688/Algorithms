package com.unit2.堆排序;

import java.util.Scanner;

public class HeapSort<T extends Comparable> {


    public static void sort(Comparable[] arr) {

        int n = arr.length;

        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n - 1 - 1) / 2; i >= 0; i--)
            shiftDown(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 原始的shiftDown过程
    private static void shiftDown(Comparable[] arr, int n, int k) {

        while (2 * k + 1 < n) {
            //左孩子节点
            int j = 2 * k + 1;
            //右孩子节点比左孩子节点大
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0)
                j += 1;
            //比两孩子节点都大
            if (arr[k].compareTo(arr[j]) >= 0) break;
            //交换原节点和孩子节点的值
            swap(arr, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 3;
        Comparable[] arr = new Comparable[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        sort(arr);
        for (Comparable i : arr) {
            System.out.print(i + " ");
        }
    }

}
