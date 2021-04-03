package com.unit3.hash;

/**
 * 散列表
 *
 * @author Kou
 * date 2021.3.14
 */

import sun.misc.Queue;

import java.util.HashMap; //哈希表
import java.util.Scanner;

public class Hash {
    // key与value类型必须是对象，不可以是int型数据。
    // key:键，value:值。散列表将键映射到值。
    // dormNames:散列表名称
    private HashMap<Integer, String> dormNames = new HashMap<Integer, String>();

    /**
     * 散列表
     */

    public Hash() {  //构造方法
        // put方法添加键值对
        dormNames.put(1, "龚子航");
        dormNames.put(2, "钱俊学");
        dormNames.put(3, "寇超杰");
        dormNames.put(4, "姜凌");
        dormNames.put(3, "kouchaojie"); // 会将上一个覆盖。

        System.out.println(dormNames.keySet().size());  //返回map中所有key值的列表/计算键值对的数量
        System.out.println(dormNames);  //输出散列表

        for (Integer k : dormNames.keySet()) {
            String str = dormNames.get(k); //get方法获取对应的value
            System.out.println(str);
        }  // 遍历hash表
    }

    /**
     * 查找散列表中的值
     *
     * @param amount
     * @return
     */
    public String getName(int amount) {
        if (dormNames.containsKey(amount)) //判断是否包含指定的键名
            return dormNames.get(amount);
        else
            return "NO FOUND";
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int amount = reader.nextInt();
        Hash Hash = new Hash();
        String name = Hash.getName(amount);
        System.out.println("您要查找的是：" + amount + "号");
        System.out.println(name);
    }
}
