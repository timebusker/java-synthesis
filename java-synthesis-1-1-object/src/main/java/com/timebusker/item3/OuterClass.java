package com.timebusker.item3;

/**
 * @DESC:ObjectTest
 * @author:timebusker
 * @date:2019/3/2
 */
public class OuterClass {

    private int idx;
    private String name;

    private class InnerClass {

        public InnerClass() {
        }

        public InnerClass(int idx, String name) {
            idx = idx;
            name = name;
        }

        public void show() {
            System.err.println(this.hashCode() + "\tidx：" + idx + "\tname：" + name);
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.setIdx(1);
        outer.setName("1111");
        // 可以直接引用外部类的成员
        InnerClass inner = outer.new InnerClass();
        inner.show();
        // 不可以修改外部类的成员属性值
        inner = outer.new InnerClass(2, "2222");
        inner.show();
    }


    public void test() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这个是匿名内部类！");
            }
        });
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
