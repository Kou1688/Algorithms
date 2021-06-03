package com.unit4.mst;

import edu.princeton.cs.algs4.UF;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小生成树的Kruskal算法
 *
 * @author Kou
 * @date: 2021/6/1 13:50
 * @Description: Kruskal
 */
public class KruskalMinSpanningTree {
    /**
     * 队列用来保存最小生成树的所有边
     */
    private Queue<Edge> mst;

    public KruskalMinSpanningTree(EdgeWeightedGraph graph) {
        mst = new LinkedList<>();
        //优先队列用来给加权边排序
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        for (Edge edge : graph.edges()) {
            priorityQueue.offer(edge);
        }
        //用于识别会形成环的边
        UF uf = new UF(graph.getVertexNum());

        while (!priorityQueue.isEmpty() && mst.size() < graph.getVertexNum() - 1) {
            Edge edge = priorityQueue.poll();
            assert edge != null;
            int vertex = edge.either();
            int otherVertex = edge.other(vertex);
            if (uf.find(vertex) == uf.find(otherVertex)) {
                continue;
            }
            uf.union(vertex, otherVertex);
            mst.offer(edge);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (Edge edge : edges()) {
            weight = weight + edge.getWeight();
        }
        return weight;
    }
}
