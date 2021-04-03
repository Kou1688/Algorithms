package com.unit2.排序模板;

//import java.util.Scanner;

import edu.princeton.cs.algs4.*;

/**
 * 排序模板
 *
 * @author Kou
 * sort 排序
 * less 调用.compareTo对元素进行比较
 * exch 对元素进行交换
 * show 在单行中打印数组
 * isSorted 测试数组元素是否有序
 */
public class Example {
    public static void sort(Comparable[] a) {
        //排序算法
        //将a[]按升序排列

        //选择排序 Selection
        /*int N = a.length; //数组的长度
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }*/

        //插入排序 Insertion  交换算法
        /*int N = a.length;
        for (int i = 1; i < N; i++) {
            //将a[i]插入
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j - 1, j);
            }
        }*/

        //插入排序改进算法  后移
        //注意数组越界问题
        /*int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable v = a[i];
            int j = i - 1;
            while (j >= 0 && less(v, a[j])) {
                a[j + 1] = a[j];
                j--;
            }
            j++;
            if (j != i)
                a[j] = v;
        }*/

        //希尔排序
        /*int N = a.length;
        int h = 1;
        //每h个为一组
        while (h < N / 3) {
            h = 3 * h + 1;  //递增序列:1,4,13,40,121,364,1093.......
        }
        while (h >= 1) {
            //将数组变为h有序
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j = j - h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }*/
    }

    private static boolean less(Comparable v, Comparable w) {
        //对元素进行比较
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        //在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[] a) {
        //测试数组元素是否有序
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
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
        String[] a = StdIn.readAllStrings(); // 读取字符串数组
        sort(a);
        assert isSorted(a);  //判断是否排序成功
        show(a);
    }
}
