package com.liz.study.question;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 14:28
 */
public class 树的子结构 {
    //遍历大树
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        //如果找到与子树相同根的值，走判断方法
        if(root1.val == root2.val){
            if(judge(root1,root2)){
                return true;
            }
        }
        //遍历左孩子，右孩子
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    //判断是否是子结构
    public boolean judge(TreeNode root, TreeNode subtree) {
        //子结构已经循环完毕，代表全部匹配
        if(subtree == null){
            return true;
        }
        //大树已经循环完毕，并未成功匹配
        if(root == null){
            return false;
        }
        //相等后判断左右孩子
        if(root.val == subtree.val){
            return judge(root.left, subtree.left) && judge(root.right, subtree.right);
        }
        return false;
    }

}
