package Node;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-25 17:00
 **/

/**
 * @Title: interviewTest
 * @Package Node
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/25 17:00
 * @version V1.0
 */
public class Node {


    //注：此处的两个成员变量权限不能为private，因为private的权限是仅对本类访问。
    int data; //数据域
    Node next;//指针域

    public Node(int data) {
        this.data = data;
    }
}
