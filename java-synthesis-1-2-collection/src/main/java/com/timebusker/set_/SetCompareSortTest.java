package com.timebusker.set_;

import com.alibaba.fastjson.JSON;
import com.timebusker.set_.model.*;
import com.timebusker.set_.utils.ComparableUtils;
import org.junit.Test;

import java.util.*;

/**
 * @DESC:SetCompareSortTest
 * @author:timebusker
 * @date:2019/1/22
 */
public class SetCompareSortTest {

    private static final Random random = new Random(10000);

    /**
     * 基于对象实现Comparable接口排序
     */
    @Test
    public void test1() {
        Set<UserEntity> set = new TreeSet<>();
        set.add(new UserEntity("d", 1));
        set.add(new UserEntity("c", 2));
        set.add(new UserEntity("b", 3));
        set.add(new UserEntity("a", 4));
        for (UserEntity user : set) {
            System.out.println(JSON.toJSONString(user));
        }
    }

    @Test
    public void test2() {
        List<GoodsEntity> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            GoodsEntity goods = new GoodsEntity();
            int rand = random.nextInt();
            goods.setId("10000" + rand);
            goods.setName("10000" + rand);
            goods.setPrice(rand);
            Set<GoodSkuEntity> skus = new TreeSet<>(new ComparableUtils());
            for (int k = 0; k < 50; k++) {
                GoodSkuEntity sku = new GoodSkuEntity();
                int skurand = random.nextInt();
                sku.setId("" + skurand);
                sku.setHeight((int) (Math.random() * 100));
                sku.setWeight((int) (Math.random() * 100));
                sku.setWidth((int) (Math.random() * 100));
                skus.add(sku);
            }
            goods.setSetSku(skus);
            list.add(goods);
        }
        System.out.println(JSON.toJSONString(list));
    }
}
