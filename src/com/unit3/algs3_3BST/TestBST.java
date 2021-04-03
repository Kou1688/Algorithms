package com.unit3.algs3_3BST;

import java.util.Scanner;

public class TestBST {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BST<Integer, Integer> bst = new BST<>();
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);
        bst.put(5, 6);
        System.out.println("查询键值为5的结点:" + bst.get(5)); //查询键值为5的结点的val值
        System.out.println("查询键值最小结点:" + bst.min());  //查询键值最小结点
        System.out.println("查询键值最大结点:" + bst.max());  //查询键值最大结点
        System.out.println("查询排名为0的结点:" + bst.select(0));  //查询排名为1的结点
        System.out.println("查询键值为1的结点排名:" + bst.rank(1));    //查询键值为1的结点排名
        System.out.println("删除最大最小键");
        bst.deleteMin();    //删除最小键
        bst.deleteMax();    //删除最大键
        System.out.println(bst.keys(0, 6));
        System.out.println("删除键值为2的结点");
        bst.delete(2);
        System.out.println(bst.keys(1, 5));
        System.out.println("添加刚刚删除的结点");
        bst.put(1, 1);
        bst.put(5, 6);
        bst.put(2, 2);
        System.out.println(bst.keys());
    }
}
