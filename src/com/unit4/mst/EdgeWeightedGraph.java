package com.unit4.mst;

import com.unit4.graph.Bag;

import java.util.Scanner;

/**
 * 加权无向图
 *
 * @author Kou
 * @date: 2021/5/27 19:35
 * @Description: 加权无向图的数据类型
 */
public class EdgeWeightedGraph {
    /**
     * 顶点数
     */
    private final int vertexNum;
    /**
     * 边数
     */
    private int edgeNum;
    /**
     * 邻接表
     */
    private final Bag<Edge>[] adj;

    /**
     * 创建一个含有vertexNum个顶点但不含有边的加权无向图
     *
     * @param vertexNum 顶点数
     */
    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        this.edgeNum = 0;
        adj = (Bag<Edge>[]) new Bag[vertexNum];

        for (int v = 0; v < vertexNum; v++) {
            adj[v] = new Bag<>();
        }
    }

    /**
     * 从输入流读取一张图
     *
     * @param in 用户输入
     */
    public EdgeWeightedGraph(Scanner in) {
        this(in.nextInt());
        int edgeNum = in.nextInt();

        for (int i = 0; i < edgeNum; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            double weight = in.nextDouble();
            Edge edge = new Edge(v, w, weight);
            addEdge(edge);
        }
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    /**
     * 添加一条边
     *
     * @param edge 一条加权边
     */
    public void addEdge(Edge edge) {
        //获取这条边上的两个顶点
        int v = edge.either(), w = edge.other(v);
        //添加边
        adj[v].add(edge);
        adj[w].add(edge);
        edgeNum++;
    }

    /**
     * v的相邻边
     *
     * @param v 一个顶点
     * @return 和v相关的所有边
     */
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    /**
     * 图的所有边
     *
     * @return 存储图的所有边的背包
     */
    public Iterable<Edge> edges() {
        Bag<Edge> bag = new Bag<>();
        for (int v = 0; v < vertexNum; v++) {
            for (Edge edge : adj[v]) {
                if (edge.other(v) > v) {
                    bag.add(edge);
                }
            }
        }
        return bag;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
