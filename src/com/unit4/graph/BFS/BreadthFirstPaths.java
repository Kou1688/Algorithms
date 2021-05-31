package com.unit4.graph.BFS;

import com.unit1.algs1_2.Stack;
import com.unit4.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kou
 * @date: 2021/5/4 11:12
 * @Description: 使用广度优先搜索查找途中的路径
 */
public class BreadthFirstPaths {
    /**
     * 到达该顶点的路径是否已知
     */
    private boolean[] marked;
    /**
     * 到达该顶点的路径上的最后一个顶点
     */
    private int[] edgeTo;
    /**
     * 起点
     */
    private final int s;

    public BreadthFirstPaths(Graph graph, int s) {
        this.s = s;
        marked = new boolean[graph.VERTEX_NUM()];
        edgeTo = new int[graph.VERTEX_NUM()];
        bfs(graph, s);
    }

    /**
     * 广度优先搜索BFS
     *
     * @param graph a graph
     * @param s     search origin
     */
    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true; //标记起点
        queue.offer(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();    //删除队头顶点
            for (int w : graph.adj(v)) {   //遍历队头顶点的所有相邻顶点
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.offer(w);
                }
            }
        }
    }

    /**
     * 是否有从顶点到v的路径
     *
     * @param v 点
     * @return YES NO
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w]) {
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }
}
