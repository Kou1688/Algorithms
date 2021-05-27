package com.unit4.digraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Kou
 * @date: 2021/5/27 14:44
 * @Description:
 */
public class KosTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Digraph g = new Digraph(in);
        KosarajuScc scc = new KosarajuScc(g);

        int m = scc.getCount();
        System.out.println(m);

        @SuppressWarnings("unchecked")
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++) {
            components[i] = new LinkedList<>();
        }
        for (int v = 0; v < g.getV(); v++) {
            components[scc.id(v)].offer(v);
        }

        for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
