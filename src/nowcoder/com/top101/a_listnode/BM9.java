package nowcoder.com.top101.a_listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

/**
 * @author cyc
 * @Description 删除链表的倒数第n个节点
 * https://www.nowcoder.com/practice/f95dcdafbde44b22a6d741baf71653f6?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=
 * @createTime 2022年03月11日 12:59
 */
public class BM9 {


    public static void main(String[] args) {


        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.createLinkedList(array);
        ListNode res = removeLastNNode(head, 2);
        ListNodeUtil.printLinkedList(res);
    }

    public static ListNode removeLastNNode(ListNode pHead, int k) {
        //常规判空处理

        ListNode res = BM8.FindKthToTail(pHead, k + 1);
        res.next = res.next.next;
        return pHead;
    }

}
