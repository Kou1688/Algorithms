package com.unit1.algs1_4;

import java.util.Iterator;

/**
 * 链背包
 *
 * @param <Item>
 * @author Kou
 * date 2021/3/20
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node {
        //结点嵌套类
        Item item;
        Node next;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        //入包
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReserveBag();
    }

    private class ReserveBag implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
