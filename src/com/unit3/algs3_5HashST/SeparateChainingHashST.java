package com.unit3.algs3_5HashST;

import com.unit3.algs3_1SeqSearch.SequentialSearchST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于拉链法的散列表
 *
 * @param <Key>   键
 * @param <Value> 值
 */
public class SeparateChainingHashST<Key, Value> {
    private int N;  // 键值对总数
    private int M;  // 散列表的大小
    private SequentialSearchST<Key, Value>[] st; // 存放链表对象的数组

    public SeparateChainingHashST() {
        this(997);  // 调用有参构造函数,创建一个997大小的散列表
    }

    /**
     * 有参构造函数
     *
     * @param M 散列表/存放链表对象的st数组大小
     */
    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];    // 赋给存放链表数组大小,大小与散列表大小一致
        for (int i = 0; i < M; i++) {  // st数组里每块存放一个链表
            st[i] = new SequentialSearchST<>();
        }
    }

    /**
     * 生成散列值
     *
     * @param key 需要生成散列值的键
     * @return 返回生成的散列值
     */
    private int hash(Key key) {
        // 用key的散列值二进制形式和0x7fffffff二进制形式进行与运算,再与M进行取余运算
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * 返回散列表的大小
     *
     * @return 散列表的大小
     */
    public int size() {
        return N;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
     * 查询
     *
     * @param key 需要查询的键
     * @return 返回键所对应的val值
     */
    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    /**
     * 添加键值
     *
     * @param key 需要添加的键
     * @param val 需要添加的值
     */
    public void put(Key key, Value val) {
        if (!contains(key)) {
            N++;
        }
        st[hash(key)].put(key, val); // 在添加键值对之前,st[hash(key)]里已经有一个链表了.
    }

    /**
     * 删除一个键
     *
     * @param key 需要删除的键
     */
    public void delete(Key key) {
        if (contains(key)) {
            N--;
        }
        st[hash(key)].delete(key);
    }

    /**
     * 对散列表进行迭代
     *
     * @return 返回存放散列表的队列(键)
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i]) {
                queue.offer(key);
            }
        }
        return queue;
    }
}
