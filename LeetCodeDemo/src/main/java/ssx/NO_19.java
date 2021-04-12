package ssx;

import java.util.HashMap;

/**
 ** Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode() {}
 *  *     ListNode(int val) { this.val = val; }
 *  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  * }
 *
 */

public class NO_19 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        ListNode next = new ListNode(2);
        System.out.println(next);
        ListNode head = new ListNode(1, next);
        System.out.println(head);
        System.out.println( removeNthFromEnd(head,1) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {// 1-next   2-null
        HashMap<Integer, ListNode> map = new HashMap<>();
        int i = 1;

        while (true){

            map.put(i++,head);
            if (head.next == null){
                break;
            }
            head = head.next;

        }
        int mapSize = map.size(); //  3  2
        int indexNum = mapSize - n +1;
        if (indexNum == 1){
            return mapSize==1 ? null : map.get(2);
        }else {
//            ListNode nodeB = map.get(indexNum);
//            map.forEach((integer, listNode) -> System.out.println(integer+" == "+listNode));


            ListNode listNode = map.get(indexNum);
            ListNode next = listNode.next;
            ListNode listNode1 = map.get(indexNum - 1);
            listNode1.next = next;

            return map.get(1);
        }
    }
}



