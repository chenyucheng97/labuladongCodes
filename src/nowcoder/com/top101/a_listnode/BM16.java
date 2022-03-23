package nowcoder.com.top101.a_listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

import java.util.HashMap;

/**
 * @author cyc
 * @Description 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * @createTime 2022年03月18日 18:14:00
 */
public class BM16 {

    public static void main(String args[]) {

        int[] array1 = new int[]{2, 2, 3, 3, 4, 5};
        int[] array0 = new int[]{1, 2, 2};
        ListNode head0 = ListNodeUtil.createLinkedList(array1);
        ListNode newHead0 = deleteDuplicatesRecursion(head0);
        ListNodeUtil.printLinkedList(newHead0);

        System.out.println();

        int[] array = new int[]{2, 2, 3, 3, 4, 1, 1, 1, 5};
        int[] array2 = new int[]{1, 2, 2};
        ListNode head = ListNodeUtil.createLinkedList(array2);
        ListNode newHead = deleteDuplicates(head);
        ListNodeUtil.printLinkedList(newHead);
    }


    public static ListNode deleteDuplicatesInOrderedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;     //空节点插入链表头部
        ListNode p = dummy;

        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int value = p.next.val;
                while (p.next != null && p.next.val == value) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }



    public static ListNode deleteDuplicatesRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        if (head.val == cur.val) {    //head与cur值相等，则改变head的位置
            while (cur != null && head.val == cur.val)   //循环遍历删除所有除head所指节点之外的其他重复节点
                cur = cur.next;
            head = deleteDuplicates(cur);    //head指针直接指向返回的结果，跳过之前重复的节点（即重复节点的第一个节点断链）
        } else                       //head与cur值不相等，则head不变
            head.next = deleteDuplicatesRecursion(cur);
        return head;
    }


    /**
     * 使用了额外的HashMap来存储值每个节点出现的次数
     * 当链表无序时可以使用该方法
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;

        HashMap<Integer, Integer> map = new HashMap<>();
        while (cur != null) {
            if (map.containsKey(cur.val)) {
                map.put(cur.val, 2);
            } else {
                map.put(cur.val, 1);
            }
            cur = cur.next;
        }
        cur = head;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (cur != null) {
            if (map.get(cur.val) == 1) {
                p.next = cur;
                p = p.next;
            } else {
                if (cur.next == null) {
                    p.next = null;
                }
            }
            cur = cur.next;
        }

        return dummy.next;
    }


}
