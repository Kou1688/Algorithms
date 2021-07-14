package com.unit4.graph.DFS;

import com.unit1.algs1_2.Stack;
import com.unit4.graph.Graph;

/**
 * 深度优先搜索
 *
 * @Author Kou
 * @Date: 2021/4/26 15:55
 * @Description: DFS
 */
public class DepthFirstPath {
    /**
     * 此顶点是否已经调用了dfs()
     */
    private final boolean[] marked;
    /**
     * 每个顶点到起点的路径。从起点到一个顶点已知的最后一条路径。
     */
    private final int[] edgeTo;
    /**
     * 起点
     */
    private final int s;

    /**
     * 深度优先搜索查找图中的路径构造方法
     *
     * @param graph 无向图
     * @param s 起点
     */
    public DepthFirstPath(Graph graph, int s) {
        this.marked = new boolean[graph.VERTEX_NUM()];
        this.edgeTo = new int[graph.VERTEX_NUM()];
        this.s = s;
        dfs(graph, s);
    }

    /**
     * 深度优先搜索DFS
     *
     * @param graph a graph
     * @param v     起点
     */
    private void dfs(Graph graph, int v) {
        //标记当前结点被调用
        marked[v] = true;
        for (int w : graph.adj(v)) {
            //如果当前结点还没有被调用
            if (!marked[w]) {
                //记录最后一条已知的路径
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    /**
     * 是否存在从s到v的路径
     *
     * @param v 终点
     * @return Yes or No
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * s到v的路径，如果不存在则返回null
     *
     * @param v 终点
     * @return Path from s to v
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
