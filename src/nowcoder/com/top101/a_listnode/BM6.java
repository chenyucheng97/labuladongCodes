package nowcoder.com.top101.a_listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

/**
 * @author cyc
 * @Description BM6 判断链表中是否有环
 * https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @createTime 2022年03月07日 20:56
 */
public class BM6 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.createLinkedList(array);

        boolean res2 = hasCycle(head);
        System.out.println("res2 = " + res2);

        ListNode pre1 = new ListNode(1);
        ListNode pre2 = new ListNode(2);
        pre1.next = head;
        head.next = pre2;
        pre2.next = head;
        boolean res = hasCycle(pre1);
        System.out.println("res = " + res);

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
