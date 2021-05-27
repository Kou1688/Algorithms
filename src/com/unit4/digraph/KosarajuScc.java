package com.unit4.digraph;

/**
 * <p>1. 在给定的一幅有向图G中，使用DepthFirstOrder来计算G的反向图的拓扑排序序列</p>
 * <p>2. 在G中进行标准的深度优先搜索，但是要按照刚才计算得到的顺序来访问所有未被标记的顶点</p>
 * <p>3. 在构造函数中，所有在同一个递归dfs调用中被访问到的顶点都在同一个强连通分量中</p>
 *
 * @author Kou
 * @date: 2021/5/27 14:16
 * @Description: 计算强连通分量的Kosaraju算法
 */
public class KosarajuScc {
    /**
     * 已被标记的顶点
     */
    private final boolean[] marked;
    /**
     * 强连通分量的标识符
     */
    private final int[] id;
    /**
     * 强连通分量的数量
     */
    private int count;

    public KosarajuScc(Digraph g) {
        marked = new boolean[g.getV()];
        id = new int[g.getV()];

        //计算反向图的拓扑排序
        DepthFirstOrder order = new DepthFirstOrder(g.reverse());
        for (int v : order.reversePost()) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        id[v] = count;

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    /**
     * v和w是强连通吗
     *
     * @param v the vertex
     * @param w the vertex
     * @return t or f
     */
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * 顶点v所在的强连通分量的标识符
     *
     * @param v the vertex
     * @return v的强连通分量的标识符
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * 图中强连通分量的总数
     *
     * @return 强连通分量数量
     */
    public int getCount() {
        return count;
    }
}
