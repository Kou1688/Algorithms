package com.unit4.Graph.BFS;

import com.unit4.Graph.Graph;

import java.util.Scanner;

/**
 * @author Kou
 * @date: 2021/5/4 11:37
 * @Description: 广度优先搜索测试用例
 */
public class BFSTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Graph graph = new Graph(in);
        int s = in.nextInt();
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, s);

        for (int v = 0; v < graph.VERTEX_NUM(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (bfs.hasPathTo(v)) {
                for (int x : bfs.pathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print("-" + x);
                    }
                }
            }
            System.out.println();
        }
    }
}
