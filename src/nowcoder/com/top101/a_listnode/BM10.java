package nowcoder.com.top101.a_listnode;

import nowcoder.com.top101.ListNode;

/**
 * @author cyc
 * @Description BM10 两个链表的第一个公共结点
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=
 * @createTime 2022年03月11日 13:08
 */
public class BM10 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode head2 = new ListNode(6);
        head2.next = node4;

        ListNode res = findPublicNode(head1, head2);
        System.out.println("res.val = " + res.val);

    }


    public static ListNode findPublicNode(ListNode head1,ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode p1 = head1;
        while (p1.next != null) {
            p1 = p1.next;
        }
        //连接两个链表，如果有共同节点，那么就变成了查找环的入口节点，
        //所以最后求出来的入口节点 后面会是一个环，如果题目要求只输出入口节点的值还行，
        // 如果是输出共同节点后面的所有节点，那么就需要用其他的方式：
        //方式1：两个指针遍历head1->head2 ,和head2->head1 , p1 p2相同时就是共同节点
        //方式2：先让两个指针移动到距离两个链表尾部相同距离的位置，然后继续遍历判断
        p1.next=head2;
        return BM7.EntryNodeOfLoop(head1);
    }

    //方式1：两个指针遍历head1->head2 ,和head2->head1 , p1 p2相同时就是共同节点
    ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }


    //方式2：先让两个指针移动到距离两个链表尾部相同距离的位置，然后继续遍历判断
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        // 计算两条链表的长度
        for (ListNode p1 = headA; p1 != null; p1 = p1.next) {
            lenA++;
        }
        for (ListNode p2 = headB; p2 != null; p2 = p2.next) {
            lenB++;
        }
        // 让 p1 和 p2 到达尾部的距离相同
        ListNode p1 = headA, p2 = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                p2 = p2.next;
            }
        }
        // 看两个指针是否会相同，p1 == p2 时有两种情况：
        // 1、要么是两条链表不相交，他俩同时走到尾部空指针
        // 2、要么是两条链表相交，他俩走到两条链表的相交点
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}
