package com.unit4.mst;

/**
 * 加权边
 *
 * @author Kou
 * @date: 2021/5/27 19:14
 * @Description: 带权重的边的数据类型
 */
public class Edge implements Comparable<Edge> {
    /**
     * 顶点之一
     */
    private final int v;
    /**
     * 另一个顶点
     */
    private final int w;
    /**
     * 边的权重
     */
    private final double weight;

    /**
     * 初始化边的构造函数
     *
     * @param v      one vertex
     * @param w      another vertex
     * @param weight 权重
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        } else {
            throw new RuntimeException("Inconsistent edge");
        }
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
