package com.unit1.algs1_3;

import java.util.Iterator;

/**
 * 链队
 *
 * @param <Item>
 * @author Kou
 * date 2021/3/20
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first; // 首元结点
    private Node last; // 尾结点
    private int N; // 元素数量

    private class Node {
        //结点嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        //入队
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        //出队
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReserveQueue();
    }

    /**
     * 迭代
     */
    private class ReserveQueue implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            Node first = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
