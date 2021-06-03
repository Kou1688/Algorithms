package com.unit4.shortestpath;

/**
 * 加权有向边
 *
 * @author Kou
 * @date: 2021/6/2 13:38
 * @Description: 加权有向边
 */
public class DirectedEdge {
    /**
     * 边的起点
     */
    private final int origin;
    /**
     * 边的终点
     */
    private final int terminus;
    /**
     * 边的权重
     */
    private final double weight;

    public DirectedEdge(int origin, int terminus, double weight) {
        this.origin = origin;
        this.terminus = terminus;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int from() {
        return origin;
    }

    public int to() {
        return terminus;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", origin, terminus, weight);
    }
}
