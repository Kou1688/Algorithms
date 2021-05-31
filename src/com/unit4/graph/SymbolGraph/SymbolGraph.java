package com.unit4.graph.SymbolGraph;

import com.unit4.graph.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;


/**
 * @author Kou
 * @date: 2021/5/16 14:34
 * @Description: 符号图
 */
public class SymbolGraph {
    private ST<String, Integer> st; //符号名➡索引
    private String[] keys;  //索引➡符号名，反向索引，保存每个顶点索引所对应的顶点名
    private Graph G;    //图，使用索引来引用图中顶点

    public SymbolGraph(String stream, String sp) {
        this.st = new ST<>();
        In in = new In(stream); //第一遍遍历
        while (in.hasNextLine()) {   //构造索引
            String[] arr = in.readLine().split(sp); //读取字符串，并用分隔符隔开

            for (int i = 0; i < arr.length; i++) {  //为每个不同的字符串关联一个索引
                if (!st.contains(arr[i])) {
                    st.put(arr[i], st.size());
                }
            }
        }

        keys = new String[st.size()];   //用来获得顶点名的反向索引是一个数组
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        this.G = new Graph(st.size());
        in = new In(stream); //第二遍遍历
        while (in.hasNextLine()) {   //构造图
            String[] arr = in.readLine().split(sp);   //将每一行的第一个顶点和该行的其他顶点相连
            int v = st.get(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                G.addEdge(v, st.get(arr[i]));
            }
        }
    }

    //s是一个顶点吗？
    public boolean contains(String s) {
        return st.contains(s);
    }

    //s的索引
    public int index(String s) {
        return st.get(s);
    }

    /**
     * 索引v的顶点名
     */
    public String name(int v) {
        return keys[v];
    }

    public Graph G() {
        return G;
    }
}
