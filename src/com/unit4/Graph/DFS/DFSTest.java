package com.unit4.Graph.DFS;

import com.unit4.Graph.DFS.DepthFirstPath;
import com.unit4.Graph.Graph;

import java.util.Scanner;

/**
 * @Author Kou
 * @Date: 2021/4/26 16:31
 * @Description: DFS测试用例
 */
public class DFSTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Graph graph = new Graph(in);
        int s = in.nextInt();
        DepthFirstPath dfs = new DepthFirstPath(graph, s);

        for (int v = 0; v < graph.VERTEX_NUM(); v++) {

            System.out.print(s + " to " + v + ": ");

            if (dfs.hasPathTo(v)) {
                for (int x : dfs.pathTo(v)) {
                    if (x == s) {  //如果x等于起点
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
