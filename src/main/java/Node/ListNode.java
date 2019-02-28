package Node;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-26 15:02
 **/

/**
 * @Title: interviewTest
 * @Package Node.structure
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/26 15:02
 * @version V1.0
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public void add(int data) {
        ListNode newNode = new ListNode(data);
        if (next == null) {
            next = newNode;
            return;
        }

        ListNode tmp = next;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }
}
