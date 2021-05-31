package com.unit4.mst;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小生成树Prim延时算法
 *
 * @author Kou
 * @date: 2021/5/31 10:46
 * @Description: MinimumSpanningTree
 */
public class LazyPrimMinimumSpanningTree {
    /**
     * 最小生成树的顶点
     */
    private final boolean[] marked;
    /**
     * 最小生成树的边
     */
    private final Queue<Edge> mst;
    /**
     * 横切边(包括失效的边)
     */
    private final PriorityQueue<Edge> priorityQueue;
    private double weight;

    public LazyPrimMinimumSpanningTree(EdgeWeightedGraph graph) {
        this.priorityQueue = new PriorityQueue<>();
        this.marked = new boolean[graph.getVertexNum()];
        this.mst = new LinkedList<>();

        //假设graph连通
        visit(graph, 0);
        while (!priorityQueue.isEmpty()) {
            //从priorityQueue中得到权重最小的边
            Edge edge = priorityQueue.poll();

            int v = edge.either();
            int w = edge.other(v);
            //跳过无效边
            if (marked[v] && marked[w]) {
                continue;
            }
            //将边添加到树中
            mst.offer(edge);
            weight = weight + edge.getWeight();
            //遍历顶点的邻接边
            if (!marked[v]) {
                visit(graph, v);
            }
            if (!marked[w]) {
                visit(graph, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph graph, int vertex) {
        //标记顶点v并将所有连接v和未标记顶点的边加入优先队列
        marked[vertex] = true;
        for (Edge edge : graph.adj(vertex)) {
            if (!marked[edge.other(vertex)]) {
                priorityQueue.offer(edge);
            }
        }
    }

    /**
     * 最小生成树的所有边
     *
     * @return 最小生成树边的队列
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * 最小生成树的权重
     *
     * @return 生成的最小生成树所有边的权重之和
     */
    public double weight() {
        return weight;
    }
}
