package com.unit1.algs1_5;

import java.util.Scanner;

/**
 * 动态连通问题
 */
public class UF {
    /**
     * 分量id(以触点为索引)
     */
    private int[] id;
    /**
     * 分量数量
     */
    private int count;

    public UF(int N) {
        //以整数标识初始化N个触点
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        //连通分量的数量
        return count;
    }

    public boolean connected(int p, int q) {
        //如果p和q存在于同一个分量返回true
        return find(p) == find(q);
    }

    /**
     * quick-find算法
     * 无法处理大型问题
     * 对于每一对pq都要遍历整个id[]数组
     * @param p
     * @return id[p]
     */
    /**
     public int find(int p) {
     //p所在的分量的标识符
     return id[p];
     }

     public void union(int p, int q) {
     //在p和q之间添加一个连接
     int pID = find(p);
     int qID = find(q);
     if (pID == qID) {
     return;
     }
     for (int i = 0; i < id.length; i++) {  //将p的分量重命名为q的名称
     if (id[i] == pID) {
     id[i] = qID;
     }
     }
     count--;
     }
     **/

    /**
     * quick-union算法
     * 森林的应用
     *
     * @param p
     * @return
     */
    public int find(int p) {
        //找到根节点
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //触点数量
        int N = in.nextInt();
        UF uf = new UF(N);
        while (in.hasNext()) {
            int p = in.nextInt();
            int q = in.nextInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + "components");
    }
}
