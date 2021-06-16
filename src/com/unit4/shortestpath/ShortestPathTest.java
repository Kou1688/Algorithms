package com.unit4.shortestpath;

import java.util.Scanner;

/**
 * @author Kou
 * @date: 2021/6/2 14:42
 * @Description: 最短路径测试用例
 */
public class ShortestPathTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(in);
        DijkstraShortestPath path = new DijkstraShortestPath(digraph, 5);

        for (int t = 0; t < digraph.getVertexNum(); t++) {
            System.out.print(5 + "to" + t);
            System.out.printf(" (%4.2f): ", path.distTo(t));

            if (path.hasPathTo(t)) {
                for (DirectedEdge edge : path.pathTo(t)) {
                    System.out.print(edge + "  ");
                }
            }

            System.out.println();
        }
    }
}
