package com.unit3.algs3_6LinearProbingHashST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于线性探测法的散列表
 *
 * @param <Key>   键
 * @param <Value> 值
 * @author Kou
 * @date 2021/4/11
 */
public class LinearProbingHashST<Key, Value> {
    private int N;  // 键值对数量
    private int M;   //键值数组的大小
    private Key[] keyArr;   //存放键的数组
    private Value[] valArr; //存放值的数组

    /**
     * 构造方法创建M大小的键值数组
     */
    public LinearProbingHashST(int M) {
        this.M = M;
        keyArr = (Key[]) new Object[M];
        valArr = (Value[]) new Object[M];
    }

    /**
     * 生成散列值
     *
     * @param key 需要添加的键
     * @return 返回生成的散列值
     */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * 散列表大小
     *
     * @return 返回散列表中键值对总数
     */
    public int size() {
        return N;
    }

    /**
     * 判断键是否在散列表中
     *
     * @param key 需要判断的键
     * @return 返回布尔值
     */
    public boolean contain(Key key) {
        return get(key) != null;
    }

    /**
     * 动态调整数组大小
     *
     * @param cap 将散列表更改为cap大小
     */
    private void resize(int cap) {
        //创建一个新的散列对象，作为临时存储
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            if (keyArr[i] != null) {    //不能添加空值
                temp.put(keyArr[i], valArr[i]);
            }
        }
        //将临时数据复制到原数组中
        keyArr = temp.keyArr;
        valArr = temp.valArr;
        M = temp.M;
    }

    /**
     * 添加新的键值对
     *
     * @param key 需要添加的键
     * @param val 键对应的值
     */
    public void put(Key key, Value val) {
        if (N >= M / 2) {
            resize(M * 2);
        }
        int i;
        //值相等覆盖,遇空添加
        for (i = hash(key); keyArr[i] != null; i = (i + 1) % M) {
            if (keyArr[i].equals(key)) {
                valArr[i] = val;
                return;
            }
        }
        //将键值添加进散列表
        keyArr[i] = key;
        valArr[i] = val;
        N++;    //键值对数量+1
    }

    /**
     * 查找键对应的值
     *
     * @param key 需要查找的键
     * @return 返回键所对应的值
     */
    public Value get(Key key) {
        for (int i = hash(key); keyArr[i] != null; i = (i + 1) % M) {
            if (keyArr[i].equals(key)) {
                return valArr[i];
            }
        }
        return null;    //未查找到,返回空值
    }

    /**
     * 删除操作
     *
     * @param key 需要删除的键
     */
    public void delete(Key key) {
        if (!contain(key)) {    //首先判断key是否在散列表中
            return;
        }
        int i = hash(key);
        while (!keyArr[i].equals(key)) {
            i = (i + 1) % M;
        }
        keyArr[i] = null;
        valArr[i] = null;
        i = (i + 1) % M;
        while (keyArr[i] != null) {
            Key keyTemp = keyArr[i];
            Value valTemp = valArr[i];
            keyArr[i] = null;
            valArr[i] = null;
            N--;
            put(keyTemp, valTemp);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N <= M / 8) {
            resize(M / 2);
        }
    }

    /**
     * 利用队列对散列表进行迭代遍历
     *
     * @return 返回散列表队列
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            if (keyArr[i] != null) {
                queue.offer(keyArr[i]);
            }
        }
        return queue;
    }
}
