package com.unit5.stringsearch;

/**
 * 暴力子字符串查找算法
 *
 * @author Kou
 * @date: 2021/6/16 14:25
 */
public class ViolenceSearchString {
    public static int search(String pattern, String txt) {
        int patLen = pattern.length();
        int txtLen = txt.length();

        for (int i = 0; i <= txtLen - patLen; i++) {
            int j;

            for (j = 0; j < patLen; j++) {
                if (pattern.charAt(j) != txt.charAt(i + j)) {
                    break;
                }
            }
            //找到匹配
            if (j == patLen) {
                return i;
            }
        }

        //未查找到匹配
        return txtLen;
    }

    public static int searchTwo(String pat, String txt) {
        int j, patLen = pat.length();
        int i, txtLen = txt.length();

        for (i = 0, j = 0; i < txtLen && j < patLen; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }

        if (j == patLen) {
            return i - patLen;
        } else {
            return txtLen;
        }
    }
}
