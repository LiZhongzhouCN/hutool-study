package com.liz.study.question;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 13:47
 */
public class 链表中倒数第k个节点 {

    public ListNode FindKthToTail(ListNode head,int k) {
        if(k <= 0)
            return null;
        ListNode low = head;
        ListNode fast = head;
        for(int i=1; i < k;i++){
            if(fast == null)
                return null;
            else
                fast = fast.next;
        }
        if(fast == null)
            return null;
        while(fast.next != null){
            low = low.next;
            fast = fast.next;
        }
        return low;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

