package com.unit4.digraph;

import com.unit1.algs1_2.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kou
 * @date: 2021/5/25 14:52
 * @Description: 有向图中基于深度优先搜索的顶点排序
 */
public class DepthFirstOrder {
    private boolean[] marked;
    /**
     * 所有顶点的前序排列(dfs的调用顺序)
     */
    private Queue<Integer> pre;
    /**
     * 所有顶点的后序排列(顶点遍历完成的顺序,在递归调用之后将顶点加入队列)
     */
    private Queue<Integer> post;
    /**
     *     所有顶点的逆后序排列(反向顶点遍历的顺序)(拓扑排序)
     */
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[G.getV()];

        for (int v = 0; v < G.getV(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        //前序排列(dfs的调用顺序)
        pre.offer(v);

        //深度优先搜索
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }

        //后序及逆后序排列
        post.offer(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
