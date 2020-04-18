package com.liz.study.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/16 22:06
 */
public class 从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null){
            sum(listNode,list);
        }
        Collections.reverse(list);
        return list;
    }

    public List sum(ListNode listNode, List<Integer> list){
        list.add(listNode.val);
        if (listNode.next != null){
            listNode = listNode.next;
            sum(listNode,list);
        }
        return list;
    }
    class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}


