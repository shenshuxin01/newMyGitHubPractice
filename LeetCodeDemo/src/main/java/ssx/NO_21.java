package ssx;

import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode() {}
 *  *     ListNode(int val) { this.val = val; }
 *  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  * }
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */

public class NO_21 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        System.out.println( mergeTwoLists(new ListNode(1,new ListNode(3)),new ListNode(2)) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode();
        ListNode returnNode = listNode;
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }


            int val1 = l1.val;
            int val2 = l2.val;

            while (true) {  // 1 3 9   7 8
                if (val1 < val2) {
                    listNode.next = l1;
                    l1 = l1.next;
                    //
                    if (l1 == null){
                        listNode.next.next = l2;
                        return returnNode.next;
                    }else {
                        val1 = l1.val;
                    }
                } else {
                    listNode.next = l2;
                    l2 = l2.next;
                    //
                    if (l2 == null) {
                        listNode.next.next = l1;
                        return returnNode.next;
                    }else {
                        val2 = l2.val;
                    }
                }
                listNode = listNode.next;
            }
    }
}