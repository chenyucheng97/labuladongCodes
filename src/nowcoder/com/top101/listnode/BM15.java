package nowcoder.com.top101.listnode;

import nowcoder.com.top101.ListNode;

import java.util.HashMap;

/**
 * @author cyc
 * @Description  删除有序链表中重复的元素-I
 * @createTime 2022年03月16日 19:23
 */
public class BM15 {
    public static void main(String[] args) {


    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1), cur = head;
        pre.next = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (cur!= null ) {
            if (map.containsKey(cur.val)) {
                pre.next =cur.next;
                cur = cur.next;
            } else {
                map.put(cur.val,cur.val);
                cur = cur.next;
                pre = pre.next;
            }

        }
    }
}
