package LeetCode.RemoveNthByNode;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2018-07-17 10:34
 **/

import LeetCode.dataStructure.ListNode;

/**
 * @Title: interviewTest
 * @Package LeetCode.No1
 * @Description: todo
 * @author yanfeng3
 * @date 2018/7/17 10:34
 * @version V1.0
 */
public class removeNth {

    private ListNode head;


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        insertNod(listNode, 2);
        insertNod(listNode, 3);
        insertNod(listNode, 4);
        insertNod(listNode, 5);
//        ListNode after = removeNthFromEnd(listNode, 4);
        ListNode after = removeNthFromEnd2(listNode, 2);
        while (after.next != null) {
            System.out.println(after.val);
            after = after.next;
        }

    }

    public static void insertNod(ListNode listNode, int value) {
        ListNode newNode = new ListNode(value);
        ListNode node = listNode;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}


