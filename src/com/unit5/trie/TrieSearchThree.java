package com.unit5.trie;

/**
 * 三向单词查找树
 *
 * @author Kou
 * @date: 2021/6/8 16:36
 * @Description:
 */
public class TrieSearchThree<Value> {
    /**
     * 根结点
     */
    private Node root;
    private int keyNum;

    /**
     * 结点嵌套类
     */
    private class Node {
        /**
         * 三向单词查找树
         */
        Node left, mid, right;
        /**
         * 与字符串相关联的值
         */
        Value val;
        /**
         * 字符
         */
        char ch;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }

        char ch = key.charAt(d);
        if (ch < x.ch) {
            return get(x.left, key, d);
        } else if (ch > x.ch) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        } else {
            return x;
        }
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char ch = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.ch = ch;
            keyNum++;
        }

        if (ch < x.ch) {
            x.left = put(x.left, key, val, d);
        } else if (ch > x.ch) {
            x.right = put(x.right, key, val, d);
        } else if (d < key.length() - 1) {
            x.mid = put(x.mid, key, val, d);
        } else {
            x.val = val;
        }
        return x;
    }

    public int size() {
        return keyNum;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 查找str的最长前缀
     *
     * @param str 需查找前缀的字符串
     * @return str的最长前缀字符串
     */
    public String longestPrefixOf(String str) {
        if (str.length() == 0) {
            return null;
        }

        int length = 0;
        Node x = root;
        int i = 0;

        //只需要计算出前缀的最后一个字符的索引值
        while (x != null && i < str.length()) {
            char ch = str.charAt(i);
            if (ch < x.ch) {
                x = x.left;
            } else if (ch > x.ch) {
                x = x.right;
            } else {
                i++;
                if (x.val != null) {
                    length = i;
                }
                x = x.mid;
            }
        }
        return str.substring(0, length);
    }
}
