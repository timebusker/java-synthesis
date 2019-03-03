package com.timebusker.set_.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @DESC:GoodsEntity
 * @author:timebusker
 * @date:2019/1/22
 */
public class GoodsEntity {

    private String id;
    private String name;
    private int price;
    private Set<GoodSkuEntity> setSku;

    public Set<GoodSkuEntity> getSetSku() {
        return setSku;
    }

    public void setSetSku(Set<GoodSkuEntity> setSku) {
        this.setSku = setSku;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public GoodsEntity() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        new HashSet<>();
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
