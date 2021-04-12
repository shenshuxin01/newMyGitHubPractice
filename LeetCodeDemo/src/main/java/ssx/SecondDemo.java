package ssx;

import java.util.ArrayList;
import java.util.List;

public class SecondDemo {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null;
        int carry = 0;

        while (l1 != null || l2 != null){
            int sum = l1.val+l2.val+carry;
            if (head == null){
                head = tail = new ListNode(sum%10);
            } else {
                tail.next = new ListNode(sum%10);
                tail=tail.next;
            }
            carry = sum/10;
            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }
        if (carry>0){
            tail.next=new ListNode(1);
        }

        return head;
    }













    public static void main(String[] args) {
        // 1 -> 2 -> 3
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        // 6 -> 9 -> 3
//        ListNode nod3 = new ListNode(3);
        ListNode nod2 = new ListNode(9,null);
        ListNode nod1 = new ListNode(6,nod2);

        showList(node1);
        showList(nod1);
        System.out.println("================");
        ListNode listNode = addTwoNumbers(node1, nod1);
        showList(listNode);

    }
    private static void showList(ListNode listNode){
        if (listNode.next == null){
            System.out.println(" "+listNode.val);
        }else {
            System.out.print(" "+listNode.val+" ->");
            showList(listNode.next);
        }
    }
}



