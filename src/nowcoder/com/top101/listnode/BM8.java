package nowcoder.com.top101.listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

/**
 * @author cyc
 * @Description 链表中倒数最后k个结点
 * https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=
 * @createTime 2022年03月11日 12:18
 */
public class BM8 {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.createLinkedList(array);
        ListNode res = FindKthToTail(head, 2);
        ListNodeUtil.printLinkedList(res);
    }


    public static ListNode FindKthToTail (ListNode pHead, int k) {

        if (pHead == null || (pHead.next == null && k == 1)) {
            return pHead;
        }
        ListNode p1 = pHead, p2 = pHead;

        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p2;
    }


}
