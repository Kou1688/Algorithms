package com.unit3.Twolookup;
/*二分查找*/

import java.util.Scanner;

public class TwoPointLookup {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        /*int result = Arrays.binarySearch(arr, 8);   //Java中自带的方法binarySearch就是二分查找
        System.out.println(result + 1);  */           //.binarySearch(object[ ], object key);
        Scanner reader = new Scanner(System.in);
        int result = reader.nextInt();
        System.out.println(BinarySearch(arr, result));
    }

    /*
     * @二分查找
     * @arr[] int数组
     * @result 需要查找的元素
     * @二分查找的数组必须是个有序数组
     * */
    private static int BinarySearch(int[] arr, int result) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {

            int mid = (low + high) / 2;
            if (result > arr[mid]) {
                low = mid + 1;
            } else if (result < arr[mid]) {
                high = mid - 1;
            } else {
                return mid + 1;
            }
        }
        return 0;
    }
}
