package nowcoder.com.top101.listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

/**
 * @author cyc
 * @Description  链表中环的入口结点
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @createTime 2022年03月09日 19:37
 */
public class BM7 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.createLinkedList(array);

        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node1;


        ListNode entryNode = EntryNodeOfLoop(node0);
        System.out.println("entryNode.val = " + entryNode.val);
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead, fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                //开始计算环长度

                fast = fast.next;
                int cycleLength = 1;
                while (fast != slow) {
                    fast = fast.next;
                    cycleLength++;
                }
                System.out.println("cycleLength = " + cycleLength);
                return slow;
            }
        }
        return new ListNode(-1);
    }

}
