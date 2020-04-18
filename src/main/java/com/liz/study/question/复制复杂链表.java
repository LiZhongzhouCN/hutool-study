package com.liz.study.question;

import java.util.HashMap;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 22:23
 */
public class 复制复杂链表 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        RandomListNode p1 = pHead;
        RandomListNode p2 = pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p1 != null) {
            map.put(p1, new RandomListNode(p1.label));
            p1 = p1.next;
        }

        while (p2 != null) {
            if (p2.next != null) {
                map.get(p2).next = map.get(p2.next);
            } else {
                map.get(p2).next = null;
            }
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }
        return map.get(pHead);
    }
}
