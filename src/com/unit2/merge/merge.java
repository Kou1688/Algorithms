package com.unit2.merge;

import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;

/**
 * @author Kou
 * date 2021/3/25
 * 归并排序
 * 用到分治思想
 */
public class merge {
    private static Comparable[] aux;  //归并用到的辅助数组

    /**
     * 自顶向下的归并排序
     *
     * @param arr
     */
   /* public static void sort(Comparable[] arr) {
        aux = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        //将数组a[lo,hi]排序
        if (hi <= lo) {    //基准条件
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);           //对左边数组排序
        sort(arr, mid + 1, hi);   //对右边数组排序
        merge(arr, lo, mid, hi);     //利用原地归并进行排序
    }*/

    /**
     * 自底向上的归并排序
     * 适合链表
     */
    public static void sort(Comparable[] arr) {
        int N = arr.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {   //sz子数组
            for (int lo = 0; lo < N - sz; lo = lo + sz + sz) { //lo子数组索引  lo<N-sz到最后一个索引lo  lo=lo+sz+sz以一个子数组的lo
                merge(arr, lo, lo + sz - 1, Math.min(N - 1, lo + sz + sz - 1));
            }
        }
    }

    /**
     * 原地归并的抽象方法
     *
     * @param arr
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] arr, int lo, int mid, int hi) {
        //将a[lo,mid]与a[mid+1,hi]归并
        int i = lo, j = mid + 1;
        //复制数组到aux[]
        if (hi + 1 - lo >= 0) {
            System.arraycopy(arr, lo, aux, lo, hi + 1 - lo);
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {  //左边数组耗尽，取右边元素
                arr[k] = aux[j++];
            } else if (j > hi) {    //右边数组耗尽，取左边元素
                arr[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {  //左元素大于右元素，取右边元素
                arr[k] = aux[j++];
            } else {    //右元素大于左元素，取左边元素
                arr[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] arr) {
        //单行打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[] arr) {
        //判断数组是否有序
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //从标准输入读取字符串，将他们排序并输出
        /*Scanner in = new Scanner(System.in);
        String s = in.nextLine().toString();
        String[] a = s.split(" ");*/
        //StdIn.readAllStrings()为引入的第三方库
        /*String[] arr = StdIn.readAllStrings(); // 读取字符串数组
        sort(arr);
        assert isSorted(arr);  //判断是否排序成功
        show(arr);*/
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Comparable[] arr = new Comparable[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        sort(arr);
        show(arr);
    }
}
