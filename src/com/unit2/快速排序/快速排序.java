package com.unit2.快速排序;

/**
 * @author Kou
 * @快速排序 date 2021.3.13
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        QuickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * QuickSort
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static void QuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = sort(arr, left, right);
            QuickSort(arr, left, pivot - 1);
            QuickSort(arr, pivot + 1, right);
        }
    }

    /**
     * sort 找出基准值，排序左右子数组
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int sort(int[] arr, int left, int right) {
        int pivotValue = arr[left]; // 基准值
        while (left < right) {
            while (left < right && arr[right] >= pivotValue) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivotValue) {
                left++;
            }
            arr[right] = arr[left];
        }
        //跳出循环后,left与right相等
        //需要将基准值放在正确的位置，将pivotValue赋值给arr[left]
        arr[left] = pivotValue;
        return left; // 返回基准值的位置
    }
}
