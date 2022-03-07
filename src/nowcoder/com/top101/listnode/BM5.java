package nowcoder.com.top101.listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

import java.util.*;

/**
 * @author cyc
 * @Description 合并k个已排序的链表
 * https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6?tpId=295&tqId=724&ru=/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6&qru=/ta/format-top101/question-ranking
 * @createTime 2022年03月07日 00:56:00
 */
public class BM5 {

    public static void main(String args[]) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.createLinkedList(array);

        int[] array2 = new int[]{2, 3, 4, 5};
        ListNode head2 = ListNodeUtil.createLinkedList(array2);

        int[] array3 = new int[]{3, 4, 5};
        ListNode head3 = ListNodeUtil.createLinkedList(array3);

        ArrayList<ListNode> KNodeList = new ArrayList(
                Arrays.asList(head, head2, head3));
        ListNode res = mergeKLists(KNodeList);
        ListNodeUtil.printLinkedList(res);
    }


    /**
     * 使用到了PriorityQueue构造一个小顶堆，每次可以从PriorityQueue中取出一个顶部的最小值
     * 关于堆： 可以把堆看作一个数组，也可以被看作一个完全二叉树，通俗来讲堆其实就是利用完全二叉树的结构来维护的一维数组
     *         https://www.jianshu.com/p/15a29c0ace73
     *         https://blog.csdn.net/weixin_30363263/article/details/80862578
     * 完全二叉树：https://blog.csdn.net/mawming/article/details/46471429
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.size(), (o1, o2) -> o1.val - o2.val);
        for (int i = 0; i < lists.size(); i++) {
            priorityQueue.offer(lists.get(i));
        }
        ListNode p = dummyNode;
        while (!priorityQueue.isEmpty()) {
            ListNode head = priorityQueue.poll();
            if (head.next != null) {
                priorityQueue.add(head.next);
            }
            p.next = head;
            p = p.next;
        }
        return dummyNode.next;
    }
}
