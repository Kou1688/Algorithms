package com.unit1.algs1_1;

import java.util.Iterator;

/**************
 * 下压(LIFO)栈 (能够动态调整数组大小的实现)
 * @author Kou
 * date 2021/3/20
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1]; // 栈元素
    private int N = 0; //元素数量

    public boolean isEmpty() { // 判空
        return N == 0;
    }

    public int size() { // 栈的大小
        return N;
    }

    private void resize(int max) {
        //调整数组大小，将大小为N<max的栈移动到一个新的大小为max的栈中
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        //将元素压入栈
        if (N == a.length) {  //如果栈满
            resize(2 * a.length);
        }
        a[N++] = item; // 注意N++是先使用再+
    }

    public Item pop() {
        // 从栈顶删除元素
        Item item = a[--N]; //注意--N是先-后使用
        a[N] = null; // 避免游离
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    /**
     * 迭代器
     *
     * @return
     */
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        // 支持后进先出的迭代
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
}
