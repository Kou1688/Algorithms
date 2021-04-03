package com.unit4.分而治之;

/**
 * @author Kou
 */
public class Sum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6};
        int n = 0;
        System.out.println(sum(arr, n));
    }

    /**
     * 递归求解数组和，使用分而治之(D&C)思想
     *
     * @param arr
     * @param n
     * @return 数组的和
     */

    private static int sum(int[] arr, int n) {
        if (n >= arr.length) {
            return 0;
        } else {
            return arr[n] + sum(arr, n + 1);
        }
    }
}
