package com.unit5.stringrank;

/**
 * @author Kou
 * @date: 2021/6/8 14:29
 * @Description:
 */
public class LowSort {
    /**
     * 通过前numChar个字符将arr[]排序
     *
     * @param arr     字符串数组
     * @param numChar 需排序的字符数
     */
    public static void sort(String[] arr, int numChar) {
        int arrLen = arr.length;
        //基数
        int r = 256;
        String[] aux = new String[arrLen];
        //KouTODO:2021/6/8 15:06 Kou :字符串排序没看懂
        for (int d = numChar - 1; d >= 0; d--) {
            //根据第d个字符用键索引计数法排序
            //计算出现频率
            int[] count = new int[r + 1];
            for (String s : arr) {
                count[s.charAt(d) + 1]++;
            }

            for (int i = 0; i < r; i++) {

            }
        }
    }
}
