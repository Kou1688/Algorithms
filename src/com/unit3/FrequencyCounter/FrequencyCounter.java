package com.unit3.FrequencyCounter;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
    public static void main(String[] args) {
        int minLen = Integer.parseInt(args[0]);   //最小键长
        ST<String, Integer> st = new ST<>();
        while (!StdIn.isEmpty()) {
            //构造符号表并统计频率
            String word = StdIn.readString();
            if (word.length() < minLen) {
                continue;   //忽略较短的单词
            }
            if (!st.contains(word)) {    //若表中不存在此键值则添加
                st.put(word, 1);
            } else { //若存在则在表中将其覆盖并且频率+1
                st.put(word, st.get(word) + 1);
            }
        }
        //找出出现频率最高的单词
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        StdOut.println(max + " " + st.get(max));
    }
}
