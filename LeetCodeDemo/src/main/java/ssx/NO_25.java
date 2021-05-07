package ssx;

import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 *给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 */

public class NO_25 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3,node4); //1,3
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2); // 1,4
        System.out.println(  reverseKGroup(node1,3));

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode next = head;
        ListNode myNode = new ListNode();
        ListNode myNodeReturn = myNode;
        int index = 1;

        do {
            //如果遍历到每k个节点的末尾节点，就执行反转操作
            if (index % k == 0) {
                ListNode next99 = head.next;
                ListNode[] listNodes = fun(next, k, myNode);// 上一次反转后的下一个节点next、k值、myNode末尾
                next = listNodes[0];
                myNode = listNodes[1];
                head=next99;
                if (head == null){
                    return myNodeReturn.next;
                }
                continue;
            }
            head=head.next;
            if (head == null){
                return myNodeReturn.next;
            }
        } while (++index > 0);

        return myNodeReturn.next;
    }

    /**
     * 方法需要实现的功能：
     *      给next值下一轮的首节点的地址
     *      myNode++
     * 方法逻辑：
     *      按照首节点开始循环，下一个节点移到首节点前一个位置
     *      交换两个节点1和2，需要三个存储变量，一个是节点1，一个是节点2，一个是节点2的next值
     */
    private static ListNode[/*next & myNode*/] fun(ListNode next,int k,ListNode myNode){
        int index=1;
        ListNode first = next;
        next=next.next;        //   1 2 3 4 5
        myNode.next=first;
        while (++index <= k){//从第二个开始
            ListNode oldNode = myNode.next;
            ListNode currentNode = next;
            ListNode nextNode = next.next;

            //进行插入，把 current节点插入到first节点前面
            myNode.next = currentNode;
            currentNode.next = oldNode;

            //next指针后移
            next=nextNode;
        }
        ListNode[] listNodes = {next, first};
        first.next=next;
        return listNodes;
    }

}
