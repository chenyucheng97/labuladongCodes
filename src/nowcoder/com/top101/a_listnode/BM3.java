package nowcoder.com.top101.a_listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

/**
 * 链表中的节点每k个一组翻转
 * https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 */
public class BM3 {

    public static void main(String args[]) {
        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head2 = ListNodeUtil.createLinkedList(array2);
        ListNode newHead2 = reverseKGroup(head2, 3);
        ListNodeUtil.printLinkedList(newHead2);
    }


    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverseBetween(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }


    public static ListNode reverseBetween(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a;
        }
        ListNode pre = null;
        ListNode cur = a;
        while (cur != b) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
