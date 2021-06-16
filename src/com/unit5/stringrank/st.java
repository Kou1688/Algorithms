package com.unit5.stringrank;

import java.util.Arrays;

/**
 * @author Kou
 * @date: 2021/6/8 15:02
 * @Description:
 */
public class st {
    public static void main(String[] args) {
        String[] str = new String[]{"3s4s", "1s2s", "5s5s", "5s8s", "9s10s"};
        Arrays.sort(str);
        for (int i=0;i< str.length;i++){
            System.out.println(str[i]);
        }
    }
}
