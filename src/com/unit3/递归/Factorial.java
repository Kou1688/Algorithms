package com.unit3.递归;

/**
 *
 * @author Kou
 * @date 2021.2.19
 * */
public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
    }

    /**
     * 递归算阶乘
     * 递归为栈结构
     * */
    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
