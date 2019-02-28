package Node;/**
 * 链表反转
 *
 * @author yanfeng3
 * @create 2019-02-25 18:42
 **/

/**
 * @Title: interviewTest
 * @Package Node
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/25 18:42
 * @version V1.0
 */
public class ReverseList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        //向LinkList中添加数据
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Node node = reverseList(list.head);


        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static Node reverseList(Node head) {

        //如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node next = null; //定义当前结点的下一个结点
        Node reverseHead = null;  //反转后新链表的表头

        while (current != null) {
            next = current.next;  //暂时保存住当前结点的下一个结点，因为下一次要用

            current.next = reverseHead; //将current的下一个结点指向新链表的头结点
            reverseHead = current;

            current = next;   // 操作结束后，current节点后移
        }

        return reverseHead;
    }

    /**
     * 头插法
     *
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        // 头结点
        ListNode root = new ListNode(0);
        ListNode nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = root.next;
            root.next = head;
            head = nextNode;
        }

        return root.next;
    }
}
