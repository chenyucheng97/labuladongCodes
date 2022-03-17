package nowcoder.com.top101.listnode;

import nowcoder.com.top101.ListNode;
import nowcoder.com.top101.ListNodeUtil;

import java.util.Arrays;
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
        ListNode res = sortLinkedList2(head);
        ListNodeUtil.printLinkedList(res);


        System.out.println();
        System.out.println("--- 归并排序 ---");

        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i]+",");
        }


    }


    /**
     * 堆排序
     * @param head
     * @return
     */
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

    /**
     * 使用递归排序
     * @param head
     * @return
     */
    public static ListNode sortLinkedList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //注意这里fast = head.next 因为最后拆分成两个的时候，要使得slow和fast分别指向这两个节点
        ListNode slow = head,fast = head.next;
        while (fast!=null&&fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortLinkedList2(head);
        ListNode right = sortLinkedList2(temp);

        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;

        while (left != null && right != null) {

            if (left.val >= right.val) {
                p.next = right;
                right = right.next;
            } else {
                p.next = left;
                left = left.next;
            }
            p = p.next;
        }
        p.next = left != null ? left : right;
        return dummyNode.next;
    }


    public static int recursionCount = 0;


    //https://www.cnblogs.com/chengxiao/p/6194356.html
    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }

    private static void sort(int[] arr,int left,int right,int []temp){
        ListNodeUtil.printIndent(recursionCount++);
        System.out.printf("left = %d, right = %d\n", left , right );
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
        ListNodeUtil.printIndent(--recursionCount);
        System.out.printf("left = %d, right = %d\n", left , right );
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        System.out.println("--- 调用 merge left = " + left +",mid = "+mid+", right = " + right + ", temp = " + temp + " ---");
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }


}
