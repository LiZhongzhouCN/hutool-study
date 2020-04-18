package com.liz.study.tree;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/3 17:43
 */
public class BinaryTree {

    /**
     *         A
     *     B      C
     *    D  E       F
     */
    private static Node root = null;
    private List<Character> list = new ArrayList<Character>();
    public BinaryTree() {
        inti();
    }

    public void inti(){
        Node e = new Node('E', null, null);
        Node d = new Node('D', null, null);
        Node f = new Node('F', null, null);
        Node b = new Node('B', d, e);
        Node c = new Node('C', null, f);
        Node a = new Node('A', b, c);
        root = a;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int treeDepth = tree.getTreeDepth(root);
        System.out.println("深度遍历："+treeDepth);
        tree.preOrderTraverse(root);
        System.out.println("前序遍历"+tree.getList());
        tree.getList().clear();
        tree.inOrderTarverse(root);
        System.out.println("中序遍历"+tree.getList());
        tree.getList().clear();
        tree.postOrderTarverse(root);
        System.out.println("后序遍历"+tree.getList());
        tree.BroadFirstSearch(root);
        System.out.println();
        tree.depthFirstSearch(root);

        for (int i = 1;i <= 20; i++){
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
    //广度优先遍历是使用队列实现的
    public void BroadFirstSearch(Node nodeHead) {
        if(nodeHead==null) {
            return;
        }
        Queue<Node> myQueue=new LinkedList<Node>();
        myQueue.add(nodeHead);
        while(!myQueue.isEmpty()) {
            Node node=myQueue.poll();
            System.out.print(node.getData()+" ");
            if(null!=node.getLeft()) {
                myQueue.add(node.getLeft());    //深度优先遍历，我们在这里采用每一行从左到右遍历
            }
            if(null!=node.getRight()) {
                myQueue.add(node.getRight());
            }
        }
    }

    //深度优先遍历
    public void depthFirstSearch(Node nodeHead) {
        if(nodeHead==null) {
            return;
        }
        Stack<Node> myStack=new Stack<Node>();
        myStack.add(nodeHead);
        while(!myStack.isEmpty()) {
            Node node=myStack.pop();    //弹出栈顶元素
            System.out.print(node.getData()+" ");
            if(node.getRight()!=null) {
                myStack.push(node.getRight());    //深度优先遍历，先遍历左边，后遍历右边,栈先进后出
            }
            if(node.getLeft()!=null) {
                myStack.push(node.getLeft());
            }
        }

    }


    /**
     * 深度遍历
     *
     * */
    public int getTreeDepth(Node node) {

        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        int left = 0, right = 0;
        if (node.getLeft() != null) {
            left = getTreeDepth(node.getLeft());
        }
        if (node.getRight() != null) {
            right = getTreeDepth(node.getRight());
        }
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 前序遍历:ABDEC
     * 1.首先遍历左子树,遍历到叶子结点为止
     * @return
     * */
    public boolean preOrderTraverse(Node node) {
        //首先从根节点开始遍历
        list.add(node.getData());
        if (node.getLeft() != null) {
            //
            preOrderTraverse(node.getLeft());
        }
        if (node.getRight() != null) {
            preOrderTraverse(node.getRight());
        }
        return true;
    }

    /**
     * 中序遍历:DBEAC
     * @return
     *
     * */
    public boolean inOrderTarverse(Node node) {
        if (node.getLeft() != null) {
            inOrderTarverse(node.getLeft());
        }
        list.add(node.getData());
        if (node.getRight() != null) {
            inOrderTarverse(node.getRight());
        }
        return true;
    }

    /**
     * 后序遍历:DEBCA
     * @return
     *
     * */
    public boolean postOrderTarverse(Node node) {
        if (node.getLeft() != null) {
            postOrderTarverse(node.getLeft());
        }
        if (node.getRight() != null) {
            postOrderTarverse(node.getRight());
        }
        list.add(node.getData());
        return true;
    }

    public List<Character> getList() {
        return list;
    }
}
