package com.unit4.graph;

import java.util.Scanner;

/**
 * 邻接表无向图
 *
 * @author Kou
 */
public class Graph {
    /**
     * 边的数目
     */
    private final int VERTEX_NUM;
    /**
     * 边的数目
     */
    private int edgeNum;
    /**
     * 邻接表
     */
    private Bag<Integer>[] adjacencyList;

    /**
     * 创建一个含有VERTEX_NUM个顶点但不含有边的图
     *
     * @param VERTEX_NUM vertex number
     */
    @SuppressWarnings("unchecked")
    public Graph(int VERTEX_NUM) {
        this.VERTEX_NUM = VERTEX_NUM;
        this.edgeNum = 0;
        //创建邻接表
        adjacencyList = (Bag<Integer>[]) new Bag[VERTEX_NUM];
        //将所有链表初始化为空
        for (int v = 0; v < VERTEX_NUM; v++) {
            adjacencyList[v] = new Bag<>();
        }
    }

    /**
     * 从标准输入流中读取一幅图
     *
     * @param in 输入
     */
    public Graph(Scanner in) {
        //读取VERTEX并将图初始化
        this(in.nextInt());
        //读取edgeNum
        int edgeNum = in.nextInt();
        for (int i = 0; i < edgeNum; i++) {
            //添加一条边,读取两个顶点
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    public int VERTEX_NUM() {
        return this.VERTEX_NUM;
    }

    public int edgeNum() {
        return this.edgeNum;
    }

    /**
     * add an edge
     *
     * @param v a vertex
     * @param w another vertex
     */
    public void addEdge(int v, int w) {
        //将w添加进v的链表中
        adjacencyList[v].add(w);
        //将v添加进w的链表中
        adjacencyList[w].add(v);
        //边的总数+1
        edgeNum++;
    }

    /**
     * 与v相邻的所有顶点
     *
     * @param v a vertex
     * @return all of v's neighbors
     */
    public Iterable<Integer> adj(int v) {
        return adjacencyList[v];
    }

    /**
     * 计算v的度数
     *
     * @param graph 图
     * @param v     v顶点
     * @return 返回v的度数
     */
    public static int degree(Graph graph, int v) {
        int degree = 0;
        for (int w : graph.adj(v)) {
            degree++;
        }
        return degree;
    }

    /**
     * 邻接表的字符串表示
     *
     * @return 邻接表字符串
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(VERTEX_NUM + "vertices," + edgeNum + " edges\n");
        for (int v = 0; v < VERTEX_NUM; v++) {
            s.append(v).append(": ");
            for (int w : this.adj(v)) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
