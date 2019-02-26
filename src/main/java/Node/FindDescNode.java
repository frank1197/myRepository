package Node;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-25 15:57
 **/

/**
 * @Title: interviewTest
 * @Package Node
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/25 15:57
 * @version V1.0
 */
public class FindDescNode {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        //向LinkList中添加数据
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(findNode(list, 4));
    }

    private static int findNode(LinkedList linkedList, int n) {

        Node first = linkedList.head;
        Node second = linkedList.head;

        for (int i = 0; i < n; i++) {
            second = second.next;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }

        return first.data;
    }

}
