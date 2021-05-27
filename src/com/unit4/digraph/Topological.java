package com.unit4.digraph;

/**
 * @author Kou
 * @date: 2021/5/25 15:50
 * @Description: 拓扑排序
 */
public class Topological {
    /**
     * 顶点的拓扑排序
     */
    private Iterable<Integer> order;

    public Topological(Digraph g) {
        //检测该图是否有环
        DirectedCycle cycleFinder = new DirectedCycle(g);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(g);

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
    public boolean isDag() {
        return order != null;
    }
}
