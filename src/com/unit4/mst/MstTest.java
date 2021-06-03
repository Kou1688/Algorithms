package com.unit4.mst;

import java.util.Scanner;

/**
 * @author Kou
 * @date: 2021/5/27 20:15
 * @Description: MST测试用例
 */
public class MstTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        EdgeWeightedGraph graph = new EdgeWeightedGraph(in);

        KruskalMinSpanningTree minimumSpanningTree = new KruskalMinSpanningTree(graph);
        for (Edge edge : minimumSpanningTree.edges()) {
            System.out.println(edge);
        }
        System.out.println(minimumSpanningTree.weight());
    }
}
