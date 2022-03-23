package nowcoder.com.top101.a_listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

import java.util.HashMap;

/**
 * @author cyc
 * @Description 删除有序链表中重复的元素-I
 * @createTime 2022年03月16日 19:23
 */
public class BM15 {
    public static void main(String[] args) {

        int[] array0 = new int[]{1,1};
        ListNode head0 = ListNodeUtil.createLinkedList(array0);
        ListNode newHead0 = deleteDuplicatesInOrderedList(head0);
        ListNodeUtil.printLinkedList(newHead0);

        System.out.println();

        int[] array = new int[]{2, 2, 3, 3, 4, 1, 1, 1, 5};
        int[] array1 = new int[]{1,1,2};
        ListNode head = ListNodeUtil.createLinkedList(array1);
        ListNode newHead = deleteDuplicates(head);
        ListNodeUtil.printLinkedList(newHead);
    }


    /**
     * 如果链表有序，那么重复元素只可能出现在相邻位置
     * @param head
     * @return
     */
    public static ListNode deleteDuplicatesInOrderedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p != null &&p.next!=null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p=p.next;
            }
        }
        return head;
    }


    public static ListNode deleteDuplicatesRecursion(ListNode head) {
        if (head == null || head.next == null)    //节点不存在或者只有一个节点时，递归结束
            return head;
        head.next = deleteDuplicatesRecursion(head.next);      //递归体，每次递归从下一个节点开始
        if (head.val == head.next.val)     //比较当前元素和下一个元素的值是否相等，相等则直接删除当前节点
            head = head.next;            //head指针指向下一个节点，表明当前节点丢失，已经不再属于这个链表
        return head;                //返回本次递归的结果
    }


    /**
     * 使用了额外的HashMap来存储值相等的节点
     * 当链表无序时可以使用该方法
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null|| head.next == null) {
            return head;
        }
        ListNode pre = head,cur = head.next;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(pre.val,pre.val);
        while (cur != null) {
            if (map.containsKey(cur.val)) {
                cur = cur.next;
                if (cur == null) {
                    pre.next = null;
                }
            } else {
                map.put(cur.val, cur.val);
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
