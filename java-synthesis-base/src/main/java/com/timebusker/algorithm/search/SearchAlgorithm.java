package com.timebusker.algorithm.search;

import com.timebusker.algorithm.AbstractAlgorithm;
import org.junit.Test;

/**
 * @Description: SearchAlgorithm:查找算法
 * @Author: Administrator
 * @Date: 2020/1/18 16:00
 **/
public class SearchAlgorithm extends AbstractAlgorithm {

    /**
     * 顺序查找：
     * <p>
     * 按顺序从头到尾依次往下查找，找到数据，则提前结束查找，找不到便一直查找下去，直到数据最后一位。
     */
    @Test
    public void sequenceSearch() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == des) {
                println(array);
                System.err.println("位置是：" + i);
                break;
            }
        }
    }

    /**
     * 将数列按有序化(递增或递减)排列，查找过程中采用跳跃式方式查找，即先以有序数列的中点位置为比较对象，如果要找的元素值小 于该中点元素，
     * 则将待查序列缩小为左半部分，否则为右半部分。通过一次比较，将查找区间缩小一半。 折半查找是一种高效的查找方法。它可以明显减少比较次数，
     * 提高查找效率。但是，折半查找的先决条件是查找表中的数据元素必须有序。
     * <p>
     * ① 首先确定整个查找区间的中间位置 mid = （ left + right ）/ 2
     * ② 用待查关键字值与中间位置的关键字值进行比较；
     * 若相等，则查找成功
     * 若大于，则在右半个区域继续进行折半查找
     * 若小于，则在左半个区域继续进行折半查找
     * ③ 对确定的缩小区域再按折半公式，重复上述步骤。
     */
    @Test
    public void binarySearch() {
        // 对集合排序
        int[] array = bubbleSort();
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] == des) {
                println(array);
                System.err.println("位置是：" + mid);
                break;
            } else if (array[mid] > des) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }


    public static int[] bubbleSort() {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
