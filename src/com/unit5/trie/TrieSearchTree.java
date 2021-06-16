package com.unit5.trie;

/**
 * 基于单词查找树的符号表
 *
 * @author Kou
 * @date: 2021/6/8 15:29
 * @Description:
 */
public class TrieSearchTree<Value> {
    private static int base = 256;
    private Node root;

    /**
     * 结点嵌套类
     */
    public static class Node {
        private Object val;
        private final Node[] next = new Node[base];
    }

    /**
     * 查找键所对应的值
     *
     * @param key 键
     * @return 键key所对应的值(如果不存在返回null)
     */
    @SuppressWarnings("unchecked")
    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        //返回以x作为根节点的子单词查找树中与key相关联的值
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            return x;
        }
        //找到第d个字符所对应的子单词查找树
        char ch = key.charAt(d);
        return get(x.next[ch], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        //如果key存在于以x为根结点的子单词查找树中则更新与它相关联的值
        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        //找到第d个字符所对应的子单词查找树
        char ch = key.charAt(d);
        x.next[ch] = put(x.next[ch], key, val, d + 1);
        return x;
    }
}
