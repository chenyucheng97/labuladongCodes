package nowcoder.com.top101.a_listnode;


import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

/**
 * @author cyc
 * @Description 合并两个排序的链表
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0
 * @createTime 2022年03月07日 00:56:00
 */
public class BM4 {

    public static void main(String args[]) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.createLinkedList(array);

        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head2 = ListNodeUtil.createLinkedList(array2);
//        ListNode result = Merge(head, head2);
        ListNode result = mergeTwoList(head, head2);
        ListNodeUtil.printLinkedList(result);
    }

    /**
     * 使用双指针，不修改原链表
     * @param a
     * @param b
     * @return
     */
    private static ListNode mergeTwoList(ListNode a, ListNode b) {
        ListNode p1 = a, p2 = b;
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        while (p1 != null && p2 != null) {
            if (p1.val >= p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummyNode.next;
    }

    /**
     * 直接将输入链表节点当作双指针
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode h = new ListNode(-1);
        ListNode cur = h;
        while(list1 != null && list2 !=null){
            if(list1.val<=list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1!=null) cur.next = list1;
        if(list2!=null) cur.next = list2;
        return h.next;
    }

}
