package com.timebusker.set_.utils;

import com.timebusker.set_.model.GoodSkuEntity;

import java.util.Comparator;

/**
 * @DESC:ObjectComparable
 * @author:timebusker
 * @date:2019/1/22
 */
public class ComparableUtils implements Comparator {


    @Override
    public int compare(Object o1, Object o2) {
        if ((o1 instanceof GoodSkuEntity) && (o2 instanceof GoodSkuEntity)) {
            return ((GoodSkuEntity) o1).getHeight() - ((GoodSkuEntity) o2).getHeight();
        }
        return 0;
    }
}
