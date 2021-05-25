package com.unit4.Digraph;

/**
 * @author Kou
 * @date: 2021/5/25 15:50
 * @Description: 拓扑排序
 */
public class Topological {
    private Iterable<Integer> order;    //顶点的拓扑排序

    public Topological(Digraph G) {
        DirectedCycle cycleFinder = new DirectedCycle(G); //检测该图是否有环
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);

            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    /**
     * G是有向无环图吗?
     *
     * @return G是有向无环图吗?
     */
    public boolean isDAG() {
        return order != null;
    }
}
