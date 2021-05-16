package com.unit4.Graph.DFS.CC;

import com.unit4.Graph.Graph;

/**
 * @author Kou
 * @date: 2021/5/16 12:06
 * @Description: 使用深度优先搜索找出图中的所有连通分量
 */
public class CC {
    private boolean[] marked;   //此顶点是否调用了dfs
    private int[] id;   //v所在的连通分量的标识符0~count-1
    private int count;  //连通分量数

    public CC(Graph G) {
        this.marked = new boolean[G.VERTEX_NUM()];
        this.id = new int[G.VERTEX_NUM()];
        for (int s = 0; s < G.VERTEX_NUM(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;   //调用当前结点
        id[v] = count;  //标记连通分量的标识符
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * v与w是否连通
     *
     * @param v a vertex
     * @param w a vertex
     * @return connect?
     */
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * v所在的连通分量的标识符
     *
     * @param v a vertex
     * @return v的连通分量标识符
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * @return 连通分量数
     */
    public int count() {
        return count;
    }
}
