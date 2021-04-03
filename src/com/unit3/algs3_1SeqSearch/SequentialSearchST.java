package com.unit3.algs3_1SeqSearch;

import java.util.Iterator;

/**
 * 基于无序链表的顺序查找
 * 支持迭代，泛型
 *
 * @author Kou
 * date 2021/3/30
 */
public class SequentialSearchST<Key, Value> implements Iterable<Key> {
    private Node first; //链表首结点
    private int N = 0;

    private class Node { //结点嵌套类
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {   //Node构造器
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        //给出键，返回对应的值
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;   //查找成功
            }
        }
        return null;    //查找失败
    }

    public void put(Key key, Value val) {
        if (val == null) { //保证所有的键的值都不为空
            delete(key);
            return;
        }
        //将key,value添加进链表中（头插）
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) { //已有，将其覆盖
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);  //未有，新建节点
        N++;
    }

    public void delete(Key key) {
        if (key == null) {  //当键为空
            throw new IllegalArgumentException("argument to delete() is null");
        }
        first = delete(first, key); //返回头结点
    }

    private Node delete(Node x, Key key) {
        if (x == null) {    //没有查找到要删除的键
            return null;
        }
        if (key.equals(x.key)) {    //找到要删除的结点
            N--;    //长度-1
            return x.next;  //找到结点后给上一个x结点的next域返回被删除结点的next
        }
        x.next = delete(x.next, key);   //递归，直到找到删除的那个结点
        return x;   //返回头结点
    }

    public int size() { //链表的大小
        return N;
    }

    public boolean isEmpty() {  //判空
        return N == 0;
    }

    public boolean contain(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is not null");
        }
        return get(key) != null;
    }

    @Override
    public Iterator<Key> iterator() {
        return new ReserveSeqSearch();
    }

    private class ReserveSeqSearch implements Iterator<Key> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Key next() {
            Key key = current.key;
            current = current.next;
            return key;
        }

        @Override
        public void remove() {

        }
    }
}
