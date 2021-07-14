package com.unit4.graph.DFS.Cycle;

import com.unit4.graph.Graph;

/**
 * @author Kou
 * @date: 2021/5/16 13:35
 * @Description: G是无环图吗？（假设不存在自环和平行边）
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        this.marked = new boolean[G.VERTEX_NUM()];
        for (int s = 0; s < G.VERTEX_NUM(); s++) {
            if (!marked[s]) {
                dfs(G, s, s);
            }
        }
    }

    private void dfs(Graph g, int v, int u) {   //u为v的上一个顶点
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
