package nowcoder.com.top101.listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

import java.util.PriorityQueue;

/**
 * @author cyc
 * @Description 单链表的排序
 * https://www.nowcoder.com/practice/f23604257af94d939848729b1a5cda08?tpId=295&tqId=1008897&ru=%2Fpractice%2Ff23604257af94d939848729b1a5cda08&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=
 * @createTime 2022年03月11日 17:11
 */
public class BM12 {


    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 2, 5};
        ListNode head = ListNodeUtil.createLinkedList(array);
        ListNode res = sortLinkedList(head);
        ListNodeUtil.printLinkedList(res);
    }


    public static ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode p1 = new ListNode(-1);
        p1.next = head;
        while (p1.next != null) {
            priorityQueue.add(p1.next);
            p1 = p1.next;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        while (!priorityQueue.isEmpty()) {
            ListNode cur = priorityQueue.poll();
            p.next = cur;
            p = p.next;
        }
        return dummyNode.next;
    }


}
