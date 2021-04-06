package com.unit3.algs3_4RedBlackBST;

/**
 * 红黑树
 *
 * @author Kou
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    /**
     * 红链接均为左链接
     * 空链接均为黑色
     */
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key;    //键
        private Value val;  //关联值
        private Node left, right;   //左右子树
        private int N;  //结点计数器
        private boolean color;  //由其父结点指向它的链接颜色

        public Node(Key key, Value val, boolean color, int N) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.N = N;
        }
    }

    private boolean isRed(Node x) {  //判断是否是红链接
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    public int size() {
        //返回这棵子树的大小
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    //左旋转
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    //右旋转
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    //转换一个结点的两个红色子结点的颜色
    //通过转换颜色来分解4-结点
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value val) {
        //查找key,找到更新val值,否则新建结点
        root = put(root, key, val);
        root.color = BLACK; //根结点颜色永远为黑
    }

    /**
     * 红黑树的插入算法
     *
     * @param h   递归查找/添加的结点
     * @param key 要添加的键
     * @param val 要添加的值
     * @return 根结点
     */
    private Node put(Node h, Key key, Value val) {
        if (h == null) {    //没有重复值,新建结点，与双亲用红色链接相连
            return new Node(key, val, RED, 1);
        }
        int temp = key.compareTo(h.key);
        if (temp < 0) {
            h.left = put(h.left, key, val);
        } else if (temp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.val = val;
        }
        //如果h右子结点是红色，左子结点黑色，左旋转h
        //如果h左子结点和且它的子结点也是红色，右旋转h
        //如果h左子结点和右子结点都是红色，转换颜色
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        } else if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        } else if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }
}
