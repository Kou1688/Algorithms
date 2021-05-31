package com.unit4.mst;

import com.unit4.graph.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;


/**
 * 最小生成树Prim即时算法
 *
 * @author Kou
 * @date: 2021/5/31 13:57
 * @Description: 最小生成树的Prim算法
 */
public class PrimMinimumSpanningTree {
    /**
     * 某顶点距离树权重最小的边
     */
    private final Edge[] edgeTo;
    /**
     * 某顶点距离树权重最小的边的权重
     * distTo[w]=edgeTo[w].weight()
     */
    private final double[] distTo;
    /**
     * 顶点vertex是否在树中
     */
    private final boolean[] marked;
    /**
     * 索引优先队列
     */
    private final IndexMinPQ<Double> priorityQueue;

    public PrimMinimumSpanningTree(EdgeWeightedGraph graph) {
        edgeTo = new Edge[graph.getVertexNum()];
        distTo = new double[graph.getVertexNum()];
        marked = new boolean[graph.getVertexNum()];

        for (int v = 0; v < graph.getVertexNum(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        priorityQueue = new IndexMinPQ<>(graph.getVertexNum());

        distTo[0] = 0.0;
        //使用顶点0和权重0初始化优先队列
        priorityQueue.insert(0, 0.0);
        //将最近的顶点添加到树中
        while (!priorityQueue.isEmpty()) {
            visit(graph, priorityQueue.delMin());
        }
    }

    private void visit(EdgeWeightedGraph graph, int vertex) {
        //将顶点v添加到树中,更新数据
        marked[vertex] = true;
        for (Edge edge : graph.adj(vertex)) {
            int w = edge.other(vertex);

            //跳过无效边
            if (marked[w]) {
                continue;
            }
            if (edge.getWeight() < distTo[w]) {
                //连接w和树的最佳边Edge变为edge
                edgeTo[w] = edge;

                distTo[w] = edge.getWeight();
                //将键(顶点索引)值(顶点距离树权重最小的边的权重)添加/更新至索引优先队列
                if (priorityQueue.contains(w)) {
                    priorityQueue.changeKey(w, distTo[w]);
                } else {
                    priorityQueue.insert(w, distTo[w]);
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Bag<Edge> mst = new Bag<>();
        for (int v = 1; v < edgeTo.length; v++) {
            mst.add(edgeTo[v]);
        }
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
