package nowcoder.com.top101.listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

/**
 * BM2 链表内指定区间反转
 * https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 */
public class BM2 {


    static ListNode nextN;

    public static void main(String args[]) {

        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.createLinkedList(array);
//        ListNode newHead = reverseN(head, 3);
        ListNode newHead = reverseN2(head, 3);
        ListNodeUtil.printLinkedList(newHead);

        System.out.println();

        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        ListNode head2 = ListNodeUtil.createLinkedList(array2);
        ListNode newHead2 = reverseBetween(head2, 3, 5);
        ListNodeUtil.printLinkedList(newHead2);

        System.out.println();

        int[] array3 = new int[]{1, 2, 3, 4, 5, 6, 7};
        ListNode head3 = ListNodeUtil.createLinkedList(array3);
        ListNode newHead3 = reverseBetween2(head3, 3, 5);
        ListNodeUtil.printLinkedList(newHead3);

    }


    /**
     * 递归反转 链表前N个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            nextN = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = nextN;
        return last;
    }


    /**
     * 递归反转 链表第m到n个节点
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


    /**
     * 迭代反转链表前n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode reverseN2(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        //保存第n个节点
        ListNode nodeN = null;
        ListNode pre = null, cur = head;
        for (int i = 0; i < n; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if (i == n - 1) {
                nodeN = cur;
            }
        }
        //此时pre指向的就是反转后的头节点
        ListNode newHead;
        newHead = pre;
        while (pre.next != null) {
            pre = pre.next;
        }
        //连接之前保存的节点
        pre.next = nodeN;
        return newHead;
    }


    /**
     * 迭代形式 反转链表的第m到第n个节点
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode p = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }
        //第m个位置的前一个节点
        ListNode preM = p;
        //第m个节点
        ListNode leftNode = preM.next;
        //寻找第n个节点
        ListNode p1 = preM;
        for (int i = 0; i <= n - m; i++) {
            p1 = p1.next;
        }
        ListNode rightNode = p1;
        //第n个节点的下一个节点
        ListNode rightNodeNext = rightNode.next;
        //切断第n个节点后的连接
        rightNode.next = null;
        //反转后重新连接
        preM.next = BM1.reverse(leftNode);
        leftNode.next = rightNodeNext;
        return dummyNode.next;
    }


}
