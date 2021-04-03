package com.unit3.algs3_1SeqSearch;

import java.util.Scanner;

public class TestSeqSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int minLen = Integer.parseInt(args[0]);   //命令行参数，最小键长
        SequentialSearchST<String, Integer> sequentialSearchST = new SequentialSearchST<>();
        while (!in.hasNext()) {
            //构造符号表并统计频率
            String word = in.next();
            if (word.length() < minLen) {
                continue;
            }
            if (!sequentialSearchST.contain(word)) {
                sequentialSearchST.put(word, 1);
            } else {
                sequentialSearchST.put(word, sequentialSearchST.get(word) + 1);
            }
        }
        String max = "";
        sequentialSearchST.put(max, 0);
        for (String word : sequentialSearchST) {
            if (sequentialSearchST.get(word) > sequentialSearchST.get(max)) {
                max = word;
            }
        }
        System.out.println(max + " " + sequentialSearchST.get(max));
    }
}
