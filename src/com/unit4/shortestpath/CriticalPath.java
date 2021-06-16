package com.unit4.shortestpath;

import java.util.Scanner;

/**
 * @author Kou
 * @date: 2021/6/3 17:26
 * @Description:
 */
public class CriticalPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // source and sink
        int source = 2*n;
        int sink   = 2*n + 1;

        // build network
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(2*n + 2);
        for (int i = 0; i < n; i++) {
            double duration = in.nextDouble();
            G.addEdge(new DirectedEdge(source, i, 0.0));
            G.addEdge(new DirectedEdge(i+n, sink, 0.0));
            G.addEdge(new DirectedEdge(i, i+n,    duration));

            // precedence constraints
            int m = in.nextInt();
            for (int j = 0; j < m; j++) {
                int precedent =in.nextInt();
                G.addEdge(new DirectedEdge(n+i, precedent, 0.0));
            }
        }

        // compute longest path
        DijkstraShortestPath lp = new DijkstraShortestPath(G, source);

        // print results
        System.out.println(" job   start  finish");
        System.out.println("--------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%4d %7.1f %7.1f\n", i, lp.distTo(i), lp.distTo(i+n));
        }
        System.out.printf("Finish time: %7.1f\n", lp.distTo(sink));
    }

}

