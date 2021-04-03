package com.unit1.algs1_3;

import java.util.Scanner;

/**
 * Queue测试用例
 *
 * @author Kou
 */
public class TestQueue {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Queue<String> queue = new Queue<String>();
        while (reader.hasNext()) {
            String item = reader.nextLine();
            if (!item.equals("-")) {
                queue.enqueue(item);
            } else if (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }
        }

        System.out.println("队列大小:" + queue.size());
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
