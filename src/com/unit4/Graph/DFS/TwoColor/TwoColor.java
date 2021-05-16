package com.unit4.Graph.DFS.TwoColor;

import com.unit4.Graph.Graph;

/**
 * @author Kou
 * @date: 2021/5/16 14:01
 * @Description: G是二分图吗？
 */
public class TwoColor {
    private boolean marked[];
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph G) {
        this.marked = new boolean[G.VERTEX_NUM()];
        this.color = new boolean[G.VERTEX_NUM()];
        for (int s = 0; s < G.VERTEX_NUM(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}
