package com.unit1.algs1_2;

import java.util.Scanner;

/**
 * @author Kou
 * Stack测试用例
 */
public class TestStack {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        while (reader.hasNext()) {
            String item = reader.nextLine();
            if (!item.equals("-")) {
                stack.push(item);
            }else if (!stack.isEmpty()){
                System.out.println(stack.pop());
            }
        }

        System.out.println("栈大小:"+stack.size());
        for (String s : stack) {
            System.out.println(s);
        }
    }
}
