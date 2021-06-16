package com.unit4.shortestpath;

import edu.princeton.cs.algs4.Topological;

import java.util.Arrays;

/**
 * 无环加权有向图的最短路径
 *
 * @author Kou
 * @date: 2021/6/3 16:40
 * @Description: 无环加权有向图的最短路径算法
 */
public class AcyclicShortestPath {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicShortestPath(EdgeWeightedDigraph graph, int origin) {
        edgeTo = new DirectedEdge[graph.getVertexNum()];
        distTo = new double[graph.getVertexNum()];

        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[origin]=0.0;

        //Topological top=new Topological(graph);
    }
}
