package ssx;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 *    /**
 *      * Definition for singly-linked list.
 *      * public class ListNode {
 *      *     int val;
 *      *     ListNode next;
 *      *     ListNode() {}
 *      *     ListNode(int val) { this.val = val; }
 *      *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *      * }
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 *
 */

public class NO_23 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        ListNode node2 = new ListNode(4);
        ListNode node1 = new ListNode(1,node2); // 1,4
//        System.out.println(node1);


        ListNode node4 = new ListNode(3);
        ListNode node3 = new ListNode(1,node4); //1,3
//        System.out.println(node3);

//        System.out.println( mergeKLists(new ListNode[]{node1,node3}) );
        System.out.println( mergeKLists(new ListNode[]{new ListNode()}) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode returnTempLN = new ListNode();
        ListNode returnLN = returnTempLN;
        final int listsLength = lists.length;
        if (listsLength==0){
            return null;
        }
        while (true) {
            int count=0;
            int tempK = Integer.MAX_VALUE;
            int tempV = Integer.MAX_VALUE;
            for (int i = 0; i < listsLength; i++) {
                //保证当前列表每一个都有值，next不确定
                //如果当前的node为空，就要处理

                try {
                    ListNode listNode = lists[i];
                    if (tempV >= listNode.val) {
                        tempV = listNode.val;
                        tempK = i;
                    }
                }catch (NullPointerException e){
                    count++;
                    if (count == listsLength){
                        return returnLN.next;
                    }
                }

                if (i == listsLength - 1) {
                    ListNode list = lists[tempK]; //获取当前批次循环的最小的list
                    lists[tempK] = list.next; //让最小的list后移
                    returnTempLN.next = list; // 最终的返回值增加一个新节点
                    returnTempLN = list; //指针后移
                }

            }

        }
//        return returnLN.next;
    }

}
