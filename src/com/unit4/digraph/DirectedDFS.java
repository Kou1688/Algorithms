package com.unit4.digraph;

/**
 * @author Kou
 * @date: 2021/5/24 13:53
 * @Description: 有向图的可达性
 */
public class DirectedDFS {
    private boolean[] marked;

    /**
     * 从G中找到从s可达的所有顶点
     *
     * @param G 有向图
     * @param s one vertex
     */
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.getV()];
        dfs(G, s);
    }

    /**
     * 在G中找到从sources中的所有顶点可达的所有顶点
     *
     * @param G      有向图
     * @param source 一个顶点集合
     */
    public DirectedDFS(Digraph G, Iterable<Integer> source) {
        marked = new boolean[G.getV()];
        for (int s : source) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * v是可达的吗
     *
     * @param v one vertex
     * @return v是可达的吗
     */
    public boolean marked(int v) {
        return marked[v];
    }

}
