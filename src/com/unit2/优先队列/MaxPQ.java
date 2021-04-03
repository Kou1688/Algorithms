package com.unit2.优先队列;


/**
 * 基于堆的优先队列
 * java.util.PriorityQueue Java系统库的优先队列
 *
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;   //基于堆的完全二叉树
    private int N = 0;  //存储在pq[1-N]中，pq[0]不使用；

    public MaxPQ(int maxN) {    //创建一个长度为maxN的优先队列
        pq = (Key[]) new Comparable[maxN + 1];  //maxN+1因为pq[0]不使用
    }

    private boolean isEmpty() {  //判空
        return N == 0;
    }

    public int size() { //返回优先队列中的元素个数
        return N;
    }

    public void insert(Key v) { //插入一个元素
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {  //删除并返回最大元素
        Key max = pq[1];  //获取最大元素
        exCh(1, N--);    //将最大元素和最后一个节点交换并删除最大元素
        pq[N + 1] = null;   //防止对象游离
        sink(1);    //恢复堆的有序性
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exCh(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * 由下至上的堆有序化(上浮)
     *
     * @param k 一个堆中，位置k的节点的父节点的位置为k/2下取整，两个子节点的位置是2k,2k+1；
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {   //k>1因为根节点不能上浮，根节点是堆有序的二叉树中的最大节点
            exCh(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 由上至下的堆有序化(下沉)
     *
     * @param k
     */
    private void sink(int k) {
        while (k * 2 <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exCh(k, j);
            k = j;
        }
    }

    /*public void sort(Comparable[] arr) {
        int N = arr.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(k);
        }
        while (N > 1) {
            exCh(1, N--);
            sink(1);
        }
    }*/
}
