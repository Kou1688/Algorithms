package com.unit2.quicksort;
/**
 * 三向切分的快速排序
 *
 * @author Kou
 * date 2021/3/27
 */

import java.util.Scanner;

public class Quick {
    private static void quicksort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) { //基准条件
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;   //lt一直指向基准值，i为当前遍历元素
        Comparable v = arr[lo];
        while (i <= gt) {   //递归条件
            int cmp = arr[i].compareTo(v);
            if (cmp < 0) {  //当前指向元素小于基准值
                exch(arr, lt++, i++);
            } else if (cmp > 0) {   //当前指向元素大于基准值
                exch(arr, i, gt--);
            } else {    //当前指向元素与基准值相等
                i++;
            }
        }
        //递归
        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {    //交换元素
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] arr) {
        for (Comparable i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Comparable[] arr = new Comparable[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        quicksort(arr);
        show(arr);
    }
}
