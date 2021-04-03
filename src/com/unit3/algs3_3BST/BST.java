package com.unit3.algs3_3BST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉查找树
 *
 * @author Kou
 * date 2021/3/31
 */
public class BST<Key extends Comparable<Key>, Value> {
    /**
     * 基于二叉查找树的符号表
     * root 根结点
     * class Node 结点嵌套类
     * Node(Key key,Value val,int N)  Node构造器
     * public int size()   返回这棵子树的大小
     * private int size(Node x)
     * 树由Node对象组成，每个对象都含有一对键值，两条链接和一个结点计数器N。
     */
    private Node root;  //二叉查找树的根结点

    private class Node {
        private Key key;    //键
        private Value val;  //值
        private Node left, right;    //左右链接
        private int N;  //结点计数器

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
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

    /**
     * 二叉查找树的查找与排序方法的实现
     * public Value get(Key key)
     * private Value get(Node x,Key key)
     * 以x为根结点的子树中查找并返回key所对应的值
     * 如果找不到返回null
     * public void put(Key key,Value val)
     * private Node put(Node x,Key key,Value val)
     * 如果key存在于以x为根结点的子树中则更新他的值
     * 否则将以key和val为键值对的新结点插入到该子树中
     */

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        //以x为根结点的子树中查找并返回key所对应的值
        //如果找不到返回null
        if (x == null) {
            return null;
        }
        int temp = key.compareTo(x.key);
        if (temp < 0) {
            return get(x.left, key);
        } else if (temp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        //如果key存在于以x为根结点的子树中则更新他的值
        //否则将以key和val为键值对的新结点插入到该子树中
        if (x == null) {    //基准条件
            return new Node(key, val, 1);
        }
        int temp = key.compareTo(x.key);
        if (temp < 0) {
            x.left = put(x.left, key, val);
        } else if (temp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 查找最大结点与最小结点
     * public Key min()/max()
     * private Node min(Node x)/max(Node x)
     * public Key floor(Key key)
     * private Node floor(Node x,Key key)
     * 给定一个key，查找小于等于key的最大键。[向下取整]
     * 给定一个key，查找大于等于key的最小键。[向上取整]
     */

    public Key min() {
        return min(root).key;   //返回最小结点键值
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;   //基准条件
        }
        return min(x.left);
    }

    public Key max() {
        return max(root).key;   //返回最大结点键值
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;   //基准条件
        }
        return max(x.right);
    }

    public Key floor(Key key) {
        //查找小于等于key的最大键。[向下取整]
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int temp = key.compareTo(x.key);
        if (temp == 0) {   //如果相等，则查找成功
            return x;
        }
        if (temp < 0) {    //当前结点的key比查找的key值大，目标一定在左子树
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);  //当前结点的key比查找的key值小，目标可能在右子树
        if (t != null) {   //找到目标，返回
            return t;
        } else { //右子树中没有符合条件的值，递归出栈
            return x;
        }
    }

    public Key ceiling(Key key) {
        //查找大于等于key的最小键[向上取整]
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int temp = key.compareTo(x.key);
        if (temp == 0) {    //如果相等，查找成功
            return x;
        }
        if (temp > 0) { //当前结点key小于需查找的key，目标一定在右子树
            return ceiling(x.right, key);
        }
        Node t = ceiling(x.left, key);  //当前结点key大于需查找的key，目标可能在右子树
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    /**
     * 查找排名为k+1的结点
     * public Key select(int k)
     * private Node select(Node x,int k)
     * 查找给定键的排名
     * public int rank(Key key)
     * private int rank(Key key,Node x)
     */

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        //返回排名为k+1的结点
        if (x == null) {   //若为空
            return null;
        }
        int temp = size(x.left);
        if (temp > k) {
            return select(x.left, k);
        } else if (temp == k) {
            return x;
        } else {
            return select(x.right, k - temp - 1);
        }
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        //返回key键的排名+1:返回比key键小的结点的数量
        if (x == null) {
            return 0;
        }
        int temp = key.compareTo(x.key);
        if (temp < 0) {
            return rank(key, x.left);    //若给定键小于根结点，递归的在左子树计算
        } else if (temp > 0) {
            //如果给定键大于根结点，返回根节点+左子树结点总数+它在右子树的排名
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);    //若相等，返回左子树结点总数
        }
    }

    /**
     * 二叉查找树的删除操作
     * 删除最大键和最小键
     * public void deleteMin()
     * private Node deleteMin(Node x)
     * public void delete(Key key)
     * private Node delete(Node x, Key key)
     * 删除指定的键
     */

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {   //若左子树为空，x就是最小结点
            return x.right; //基准条件
        }
        x.left = deleteMin(x.left); //递归检索左子树
        x.N = size(x.left) + size(x.right) + 1;   //更新计数器
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.N = size(x.right) + size(x.left) + 1;
        return x;
    }

    public void delete(Key key) {
        //删除指定的结点
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int temp = key.compareTo(x.key);
        if (temp < 0) {
            x.left = delete(x.left, key);
        } else if (temp > 0) {
            x.right = delete(x.right, key);
        } else { //找到需要删除的结点
            if (x.right == null) {
                return x.left;
            } else if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);   //将x指向它的后继结点，即它的右子树上的最小结点
            x.right = deleteMin(t.right);   //返回删除右子树最小结点后的右子树的根结点
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 二叉查找树的范围查找操作
     */

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        int tempLo = lo.compareTo(x.key);
        int tempHi = hi.compareTo(x.key);
        if (tempLo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (tempLo <= 0 && tempHi >= 0) {   //在查找范围内，入队
            queue.offer(x.key);
        }
        if (tempHi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }
}
