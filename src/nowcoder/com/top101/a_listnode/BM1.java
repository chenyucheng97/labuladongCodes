package nowcoder.com.top101.a_listnode;


import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

/**
 * 2022/3/6
 * 链表的算法解题最好是用迭代法，递归法会使得空间复杂度为O(N)，但是有部分代码还是要用到递归思想
 */


/**
 *  * BM1 反转链表
 *  * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 */
public class BM1 {


    public static void main(String args[]) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.createLinkedList(array);
        ListNode newHead = reverse(head);
        ListNodeUtil.printLinkedList(newHead);

        System.out.println();

        int[] array2 = new int[]{6, 7, 8, 9, 10};
        ListNode head2 = ListNodeUtil.createLinkedList(array2);
        ListNode newHead2 = reverse2(head2);
        ListNodeUtil.printLinkedList(newHead2);

    }


    /**
     * 迭代解法
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


}
