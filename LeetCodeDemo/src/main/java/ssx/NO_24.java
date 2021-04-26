package ssx;

import java.util.Optional;

/**
 *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *  
 *
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 *
 */

public class NO_24 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();


        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3,node4); //1,3
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2); // 1,4
//        System.out.println(node1);


//        System.out.println(node3);
        System.out.println( swapPairs(node1) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode maybeNull1 = head;
        ListNode maybeNull2 = null;
        ListNode tem1 = new ListNode(),tem2 = tem1;
        try {
            maybeNull2 = head.next;

            int index = -1;
            ListNode firstNode = null;
            //遍历head链表里面所有的节点
            while (true){

                //取出偶数下标的节点，和下一个奇数节点交换位置
                if ((++index) % 2 == 0) {
                    firstNode = head;
                    ListNode secondNode = head.next;//如果此处抛异常NullPointerException

                    //第一个节点的next指向第三个节点
                    firstNode.next = secondNode.next;//如果此处抛异常NullPointerException,证明遍历到最后一个了，直接返回

//                firstNode.next= Optional.ofNullable(secondNode.next).orElseGet(() -> {return null;});
                    //第二个节点的next指向第一个节点
                    secondNode.next = firstNode;

                    //校正head的指针
                    head = secondNode;

//                    maybeNull2的 = head;   0 1 2 3 4
                    tem1.next=secondNode;
                    tem1.next.next=secondNode.next;
                    tem1=tem1.next.next;

                }
                head = head.next;

            }
        }catch (NullPointerException e){
            if (maybeNull1 == null){
                return null;
            }
            if (maybeNull2 == null){
                return maybeNull1;
            }
            return tem2.next;
        }


    }

}
