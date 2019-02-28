package Node;/**
 * 1->2->3->4
 * 2->1->4->3
 * @author yanfeng3
 * @create 2019-02-26 15:14
 **/

/**
 * @Title: interviewTest
 * @Package Node
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/26 15:14
 * @version V1.0
 */
public class swapPairs {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.add(2);
        listNode.add(3);
        listNode.add(4);

        ListNode newNode = swapPairs(listNode);

        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0); // 头结点
        node.next = head;

        // p指向新的链表的尾结点
        ListNode p = node;
        ListNode tmp;

        // 每两个进行操作
        while (p.next != null && p.next.next != null) {
            // 记录下一次要进行处理的位置
            tmp = p.next.next;
            // 下面三句完成两个结点交换
            p.next.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;
            // 指向返回链表的新的尾结点
            p = tmp.next;
        }

        head = node.next;
        node.next = null;

        return head;
    }
}
