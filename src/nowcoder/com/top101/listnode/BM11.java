package nowcoder.com.top101.listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

/**
 * @author cyc
 * @Description 链表相加(二)
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 * https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=
 * @createTime 2022年03月11日 16:58
 */
public class BM11 {


    public static void main(String[] args) {
        int[] array = new int[]{9,  3, 7};
        ListNode head = ListNodeUtil.createLinkedList(array);

        int[] array2 = new int[]{6, 3};
        ListNode head2 = ListNodeUtil.createLinkedList(array2);

        ListNode res = mergeTwoList(head, head2);
        ListNodeUtil.printLinkedList(res);
    }

    public static ListNode mergeTwoList(ListNode head1, ListNode head2) {

        //判空处理省略

        ListNode p1 = BM1.reverse(head1);

        ListNode p2 = BM1.reverse(head2);
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;

        boolean isNeedUp = false;
        while (p1 != null && p2 != null) {
            p.next = new ListNode((p1.val + p2.val+ (isNeedUp?1:0))%10);
            isNeedUp = p1.val + p2.val+ (isNeedUp?1:0) >= 10;
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            int temp = (p1.val + (isNeedUp?1:0))%10;
            isNeedUp = p1.val + (isNeedUp?1:0) >= 10;
            p1.val = temp;
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        while (p2 != null) {
            int temp = (p2.val + (isNeedUp?1:0))%10;
            isNeedUp = p2.val + (isNeedUp?1:0) >= 10;
            p2.val = temp;
            p.next = p2;
            p2 = p2.next;
        }

        //最后还有进位，则再补一个新节点
        if (isNeedUp) {
            p.next = new ListNode(1);
        }

        return BM1.reverse(dummyNode.next);
    }

}
