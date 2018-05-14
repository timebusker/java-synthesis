package com.timebusker.generics;

/**
 * @DESC:边界符测试
 * @author: timebusker
 * @date:2018/5/14
 */
public class GenericsBorderTest {
    /**
     * 现在我们要实现这样一个功能，查找一个泛型数组中大于某个特定元素的个数。
     */

//    public static <T> int countGreaterThan(T[] anArray, T elem) {
//        int count = 0;
//        for (T e : anArray) {
//            if (e > elem)  // 编译不通过
//                ++count;
//        }
//        return count;
//    }

    /**
     * 比较三个值并返回最大值
     *
     * @param x
     * @param y
     * @param z
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        // 假设x是初始最大值
        if (y.compareTo(max) > 0) {
            //y 更大
            max = y;
        }
        if (z.compareTo(max) > 0) {
            // 现在 z 更大
            max = z;
        }
        // 返回最大对象
        return max;
    }

    public static void main(String args[]) {
        System.out.printf("%d, %d 和 %d 中最大的数为 %d\n\n", 3, 4, 5, maximum(3, 4, 5));
        System.out.printf("%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
        System.out.printf("%s, %s 和 %s 中最大的数为 %s\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
    }


    /**
     * 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型
     *
     * @param x
     * @param y
     * @param z
     * @param <T>
     * @return
     */
    public static <T extends Integer> T maximum(T x, T y, T z) {
        T max = x;
        // 假设x是初始最大值
        if (y.intValue()> 0) {
            //y 更大
            max = y;
        }
        if (z.compareTo(max) > 0) {
            // 现在 z 更大
            max = z;
        }
        // 返回最大对象
        return max;
    }
}
