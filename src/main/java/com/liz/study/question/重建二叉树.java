package com.liz.study.question;


import java.util.Arrays;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/16 22:52
 */
public class 重建二叉树 {

    public static void main(String[] args) {
        重建二叉树 c = new 重建二叉树();
        TreeNode treeNode = c.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //递归调用的终止条件
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        //由前序遍历得到该二叉树的根结点
        TreeNode root = new TreeNode(pre[0]);
        //在中序遍历中找根结点位置，进行左右子树的划分
        for(int i = 0; i < in.length; i++){
            if(root.val == in[i]) {
                //将左子树看成一棵二叉树调用该方法，可以得到左子树根结点，即上面根结点的左子结点
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                //将右子树看成一棵二叉树调用该方法，可以得到右子树根结点，即上面根结点的右子结点
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                //找到根结点位置便跳出循环
                break;
            }
        }
        //返回根结点
        return root;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

