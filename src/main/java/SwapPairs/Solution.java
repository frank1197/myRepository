package SwapPairs;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-01-09 18:44
 **/

import com.alibaba.fastjson.JSON;

/**
 * @Title: interviewTest
 * @Package SwapPairs
 * @Description: todo
 * @author yanfeng3
 * @date 2019/1/9 18:44
 * @version V1.0
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = null;

        ListNode swapNodes = swapNodes(node, 2, 4);
        System.out.println(JSON.toJSONString(swapNodes));
    }

    public static ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode node1Prev=null,node2Prev=null;
        ListNode cur=dummy;
        while(cur.next!=null){
            if(cur.next.val==v1){
                node1Prev=cur;
            }else if(cur.next.val==v2){
                node2Prev=cur;
            }
            cur=cur.next;
        }
        if(node1Prev==null||node2Prev==null)
            {return head;}
        if(node2Prev.next==node1Prev){
            ListNode t=node1Prev;
            node1Prev=node2Prev;
            node2Prev=t;
        }
        ListNode node1=node1Prev.next;
        ListNode node2=node2Prev.next;
        if(node1Prev.next==node2Prev){
            node1Prev.next=node2;
            node1.next=node2.next;
            node2.next=node1;
        }else{
            node1Prev.next=node1.next;
            node2Prev.next=node2.next;
            node2.next=node1Prev.next;
            node1Prev.next=node2;
            node1.next=node2Prev.next;
            node2Prev.next=node1;
        }
        return dummy.next;

    }
}
