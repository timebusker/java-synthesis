package com.timebusker.algorithm.tree;

import com.timebusker.algorithm.AbstractAlgorithm;
import com.timebusker.algorithm.Node;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: BinaryTree：二叉树常用算法
 * @Author: Administrator
 * @Date: 2020/1/18 17:04
 **/
public class BinaryTree extends AbstractAlgorithm {

    /**
     * 递归遍历树：根-左-右
     */
    @Test
    public void loopTree() {
        loopTree(root);
    }

    private void loopTree(Node node) {
        if (node != null) {
            System.err.print(" --> " + node.getData());
            loopTree(node.getLeft());
            loopTree(node.getRight());
        }
    }

    /**
     * 层次遍历:先进先出队列
     */
    @Test
    public void queueTree() {
        Queue<Node> queue = new LinkedList<Node>();
        if (root != null) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
        }
        println(queue);
    }

    /**
     * 层次遍历:先进后出队列
     */
    @Test
    public void stackTree() {
        Stack<Node> stack = new Stack<Node>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null) {
                    stack.push(node.getLeft());
                }
                if (node.getRight() != null) {
                    stack.push(node.getRight());
                }
            }
        }
        println(stack);
    }

    /**
     * 遍历节点数
     */
    @Test
    public void countNodes() {
        System.err.println(count(root));
    }

    private static int count(Node root) {
        if (root == null) {
            return 0;
        }
        return count(root.getLeft()) + count(root.getRight()) + 1;
    }

    /**
     * 计算第K层节点数
     */
    @Test
    public void calcNodes() {
        System.err.println(calcNodes(root, 2));;
    }

    public static int calcNodes(Node node, int k) {
        if (root == null || k < 0) {
            return 0;
        } else if (k == 0) {
            return 1;
        }
        return calcNodes(root.getLeft(), k - 1) + calcNodes(root.getRight(), k - 1);
    }
}
