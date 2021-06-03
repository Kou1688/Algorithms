package com.unit4.shortestpath;

/**
 * 任意顶点对之间的最短路径
 *
 * @author Kou
 * @date: 2021/6/3 14:57
 * @Description: 两点间的最短路径
 */
public class DijkstraAllPairsShortestPath {
    private DijkstraShortestPath[] all;

    public DijkstraAllPairsShortestPath(EdgeWeightedDigraph graph) {
        all = new DijkstraShortestPath[graph.getVertexNum()];

        for (int v = 0; v < graph.getVertexNum(); v++) {
            all[v] = new DijkstraShortestPath(graph, v);
        }
    }

    /**
     * s到t的最短路径
     *
     * @param s a vertex
     * @param t other vertex
     * @return 最短路径
     */
    public Iterable<DirectedEdge> path(int s, int t) {
        return all[s].pathTo(t);
    }

    /**
     * s到t的最短距离
     *
     * @param s a vertex
     * @param t other vertex
     * @return 最短距离
     */
    public double dist(int s, int t) {
        return all[s].distTo(t);
    }
}
