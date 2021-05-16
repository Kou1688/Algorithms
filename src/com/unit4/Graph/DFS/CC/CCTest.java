package com.unit4.Graph.DFS.CC;

import com.unit4.Graph.Bag;
import com.unit4.Graph.Graph;

import java.util.Scanner;

/**
 * @author Kou
 * @date: 2021/5/16 12:44
 * @Description:
 */
public class CCTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Graph G = new Graph(in);
        CC cc = new CC(G);

        int M = cc.count();
        System.out.println(M + " components");

        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[M];    //用每个顶点所在的子图的标识符作为数组的索引
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<>();    //添加背包存放顶点
        }

        for (int v = 0; v < G.VERTEX_NUM(); v++) {  //添加连通分量
            components[cc.id(v)].add(v);    //cc.id(v):当前顶点的连通分量标识符
        }

        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
