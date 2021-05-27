package com.unit4.digraph;

import com.unit1.algs1_2.Stack;

/**
 * @author Kou
 * @date: 2021/5/24 18:16
 * @Description: 寻找有向环
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;   //路径
    private boolean[] onStack;  //递归调用栈上的所有顶点
    private Stack<Integer> cycle;   //有向环中的所有顶点（如果存在）

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        marked = new boolean[G.getV()];
        for (int v = 0; v < G.getV(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;

        for (int w : G.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {  //如果w没有被标记，标记w，递归地进行dfs(w)
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {  //如果w已经被标记,判断w是否在栈内，onStack[w]=True?
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v]=false;
    }

    /**
     * @return 是否有有向环
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * @return 有向环中的所有顶点
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
}
