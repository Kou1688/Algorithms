package com.unit1.algs1_2;

import java.util.Iterator;

/**
 * 下压堆栈 (链表实现)
 * date 2021/3/20
 *
 * @param <Item>
 * @author Kou
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first; // 栈顶(首元结点)
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

    public void push(Item item) {
        //将元素压入栈
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        //出栈
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseStack();
    }

    private class ReverseStack implements Iterator<Item> {
        // 支持后进先出的迭代
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
