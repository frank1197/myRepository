package Node;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-01-16 18:06
 **/

/**
 * @Title: interviewTest
 * @Package Node
 * @Description: todo
 * @author yanfeng3
 * @date 2019/1/16 18:06
 * @version V1.0
 */
public class findelem {


    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        System.out.println(method(node, 1).val);

    }

    public static Node method(Node head,int k) {
//        if(k<1) {
//            return null;
//        }
//        Node p1=head;
//        Node p2=head;
//        for(int i=0;i<k-1&&p1!=null;i++) {
//            p1=p1.next;
//        }
//        if(p1==null) {
//            System.out.print("error");
//            return null;
//        }
//        while(p1!=null) {
//            p1=p1.next;
//            p2=p2.next;
//        }
//        return p2;
        Node node=head;
        while(node. next!= null&&k>0){
            node=node. next;
            k--;
        }
        while(node!= null){
            node=node. next;
            head=head. next;
        }
        return head;
    }

    static class Node {

        public int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
