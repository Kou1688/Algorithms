package com.unit4.shortestpath;

import com.unit4.graph.Bag;

import java.util.Scanner;

/**
 * 加权有向图
 *
 * @author Kou
 * @date: 2021/6/2 13:38
 * @Description: 加权有向图
 */
public class EdgeWeightedDigraph {
    /**
     * 顶点总数
     */
    private final int vertexNum;
    /**
     * 边的总数
     */
    private int edgeNum;
    /**
     * 邻接表
     */
    private final Bag<DirectedEdge>[] adj;

    /**
     * 创建一个含有vertexNum个顶点0条边的加权有向图
     *
     * @param vertexNum 顶点数目
     */
    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int vertexNum) {
        this.vertexNum = vertexNum;
        this.edgeNum = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[vertexNum];

        for (int v = 0; v < vertexNum; v++) {
            adj[v] = new Bag<>();
        }
    }

    /**
     * 从输入流读取一张图
     *
     * @param in 用户输入
     */
    public EdgeWeightedDigraph(Scanner in) {
        this(in.nextInt());
        int edgeNum = in.nextInt();

        for (int e = 0; e < edgeNum; e++) {
            int origin = in.nextInt();
            int terminus = in.nextInt();
            double weight = in.nextDouble();
            DirectedEdge edge = new DirectedEdge(origin, terminus, weight);
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
     * 将edge添加到边中
     *
     * @param edge 需要添加的边
     */
    public void addEdge(DirectedEdge edge) {
        adj[edge.from()].add(edge);
        edgeNum++;
    }

    public Iterable<DirectedEdge> adj(int vertex) {
        return adj[vertex];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < vertexNum; v++) {
            for (DirectedEdge edge : adj[v]) {
                bag.add(edge);
            }
        }
        return bag;
    }
}
