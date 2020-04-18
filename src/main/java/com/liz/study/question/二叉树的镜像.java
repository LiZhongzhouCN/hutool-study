package com.liz.study.question;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 14:38
 */
public class 二叉树的镜像 {

    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
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
