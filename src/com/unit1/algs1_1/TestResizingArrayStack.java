package com.unit1.algs1_1;

import java.util.Scanner;

/**
 * ResizingArrayStack的测试用例
 *
 * @author Kou
 */
public class TestResizingArrayStack {
    public static void main(String[] args) {
        ResizingArrayStack<String> arrayStack = new ResizingArrayStack<String>();
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            String item = reader.nextLine();
            if (!item.equals("-")) {
                arrayStack.push(item);
            } else if (!arrayStack.isEmpty()) {
                System.out.println(arrayStack.pop());
            }
        }

        System.out.println("栈的大小:" + arrayStack.size());
        for (String s : arrayStack) {
            System.out.println(s);
        }
    }
}
