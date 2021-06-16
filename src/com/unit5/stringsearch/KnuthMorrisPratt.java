package com.unit5.stringsearch;

/**
 * KMP算法
 *
 * @author Kou
 * @date: 2021/6/16 15:55
 */
public class KnuthMorrisPratt {
    private final String pattern;
    private final int[] next;

    public KnuthMorrisPratt(String pattern) {
        this.pattern = pattern;
        this.next = new int[pattern.length()];

        //初始化next数组
        int j;
        next[0] = -1;
        next[1] = 0;

        for (int i = 2; i < pattern.length(); i++) {
            j = next[i - 1];

            //不右移
            /*
            //前后缀不相同时
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = next[j - 1];
            }
            //前后缀相同时
            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
            }
            //更新next数组
            next[i] = j;*/

            //右移
            while (j != -1) {
                //前后缀相同时
                if (pattern.charAt(i - 1) == pattern.charAt(j)) {
                    next[i] = j + 1;
                    break;
                } else {
                    //前后缀不同
                    j = next[j];
                }
                next[i] = 0;
            }
        }

    }

    public int search(String txt) {
        int patLen = this.pattern.length();
        int txtLen = txt.length();
        int i = 0, j = 0;

        while (i < txtLen && j < patLen) {
            if (j == -1 || txt.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == patLen) {
            return i - patLen;
        } else {
            return -1;
        }
    }
}
