package nowcoder.com.top101;



public class ListNodeUtil {


    public static ListNode createLinkedList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("List is null");
        }
        ListNode current = head;
        while (current != null) {
            System.out.printf("%d -> ", current.val);
            current = current.next;
        }
        System.out.print("NULL");
    }

    public static void main(String args[]) {
        int[] array = new int[] {
            1, 2, 3, 4, 5
        };
        ListNode head = createLinkedList(array);
        printLinkedList(head);
    }

}
