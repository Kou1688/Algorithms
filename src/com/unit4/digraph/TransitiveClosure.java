package com.unit4.digraph;

/**
 * 顶点对的可达性
 *
 * @author Kou
 * @date: 2021/5/27 15:52
 * @Description: 顶点对的可达性
 */
public class TransitiveClosure {
    private final DirectedDFS[] all;

    public TransitiveClosure(Digraph g) {
        all = new DirectedDFS[g.getV()];
        for (int v = 0; v < g.getV(); v++) {
            all[v] = new DirectedDFS(g, v);
        }
    }

    public boolean reachable(int v, int w) {
        return all[v].marked(w);
    }
}
