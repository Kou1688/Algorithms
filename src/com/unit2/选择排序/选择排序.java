package com.unit2.选择排序;

public class 选择排序 {
    /* *
     * 选择排序
     * @param array	数组
     * @return 排序好的数组(从小到大)
     */
    private static int[] findMinNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 6, 8, 7, 9, 10, 5, 4};
        int[] resultArr = findMinNumber(arr);
        for (int i = 0; i < resultArr.length; i++) {
            System.out.print(resultArr[i] + " ");
        }
    }
}
