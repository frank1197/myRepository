package Node;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.add(4);
        node1.add(3);

        ListNode node2 = new ListNode(5);
        node2.add(6);
        node2.add(4);

        ListNode newNode = addTwoNumbers(node1, node2);
        while (newNode.next != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
