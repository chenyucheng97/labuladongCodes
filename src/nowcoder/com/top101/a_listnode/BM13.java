package nowcoder.com.top101.a_listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

/**
 * @author cyc
 * @Description BM13 判断一个链表是否为回文结构
 * @createTime 2022年03月16日 10:08
 */
public class BM13 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.createLinkedList(array);

        int[] array2 = new int[]{1, 2, 3, 2, 1};
        ListNode head2 = ListNodeUtil.createLinkedList(array2);

        boolean isPalindrome1 = palindrome(head);
        boolean isPalindrome2 = palindrome(head2);
        System.out.println("isPalindrome1 = " + isPalindrome1);
        System.out.println("isPalindrome2 = " + isPalindrome2);
    }


    public static boolean palindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //奇数时再移动一位
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = BM1.reverse(slow);
        while (right != null) {
            if (left.val == right.val) {
                left = left.next;
                right = right.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
