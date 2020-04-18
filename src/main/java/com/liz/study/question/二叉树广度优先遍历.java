package com.liz.study.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 20:59
 */
public class 二叉树广度优先遍历 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) {
            return list;
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            TreeNode node=que.poll();
            list.add(node.val);
            if(null!= node.left) {
                que.add(node.left);
            }
            if(null!= node.right) {
                que.add(node.right);
            }
        }
        return list;
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
