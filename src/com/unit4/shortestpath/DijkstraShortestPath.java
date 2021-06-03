package com.unit4.shortestpath;

import com.unit1.algs1_2.Stack;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.Arrays;

/**
 * DijkstraSP
 *
 * @author Kou
 * @date: 2021/6/3 13:57
 * @Description: 迪克斯特拉算法
 */
public class DijkstraShortestPath {
    /**
     * 某顶点距离起点权重最小的边
     */
    private final DirectedEdge[] edgeTo;
    /**
     * 某顶点距离起点权重最小的边的权重
     */
    private final double[] distTo;
    /**
     * 索引优先队列，辅助寻找路径
     */
    private final IndexMinPQ<Double> priorityQueue;

    /**
     * 狄克斯特拉的构造函数
     *
     * @param graph  加权有向图
     * @param origin 起点
     */
    public DijkstraShortestPath(EdgeWeightedDigraph graph, int origin) {
        this.edgeTo = new DirectedEdge[graph.getVertexNum()];
        this.distTo = new double[graph.getVertexNum()];
        this.priorityQueue = new IndexMinPQ<>(graph.getVertexNum());

        //初始化所有边至起点的权重
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[origin] = 0.0;

        //通过索引优先队列寻找最优边
        priorityQueue.insert(origin, 0.0);
        while (!priorityQueue.isEmpty()) {
            relax(graph, priorityQueue.delMin());
        }
    }

    /**
     * 边的松弛，求最短路径
     *
     * @param graph  加权有向图
     * @param vertex a vertex
     */
    private void relax(EdgeWeightedDigraph graph, int vertex) {
        for (DirectedEdge edge : graph.adj(vertex)) {
            int terminus = edge.to();
            if (distTo[terminus] > distTo[vertex] + edge.getWeight()) {
                distTo[terminus] = distTo[vertex] + edge.getWeight();
                edgeTo[terminus] = edge;

                if (priorityQueue.contains(terminus)) {
                    priorityQueue.changeKey(terminus, distTo[terminus]);
                } else {
                    priorityQueue.insert(terminus, distTo[terminus]);
                }
            }
        }
    }

    /**
     * 从起点到vertex的距离
     *
     * @param vertex a vertex
     * @return 从起点到目标顶点的距离，若不存在则为无穷大
     */
    public double distTo(int vertex) {
        return distTo[vertex];
    }

    /**
     * 判断是否存在从顶点s到vertex的路径
     *
     * @param vertex a vertex
     * @return true or false
     */
    public boolean hasPathTo(int vertex) {
        return distTo[vertex] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        }

        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[vertex]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }

        return path;
    }
}
