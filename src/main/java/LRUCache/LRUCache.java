package LRUCache;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-04-17 20:16
 **/

import java.util.HashMap;

/**
 * @Title: interviewTest
 * @Package LRUCache
 * @Description: todo
 * @author yanfeng3
 * @date 2019/4/17 20:16
 * @version V1.0
 */
public class LRUCache {

    /**
     * 需要实现以下
     * 1.维护一个双向链表，还有他的头结点和尾结点
     * 2.插入数据时，首先判断cache中是否有该结点？如果没有，检查缓存是否还有空间？如果没有空间，清除双线链表的尾部结点。将该结点插入到双向链表的头部
     * 3.根据key获得数据的时候，查看cache中是否有key对应的结点？如果有，将该结点插入到头结点前面，返回数据：：如果没有，返回-1。
     */
    private int capacity;
    private LinkNode first;
    private LinkNode last;
    private HashMap<Integer,LinkNode> cache;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache = new HashMap<Integer,LinkNode>(capacity);
    }

    public int get(int key) {
        LinkNode res=cache.get(key);
        if(res==null){
            return -1;
        }
        moveNodeToFirst(res);
        return res.val;
    }

    public void put(int key, int value) {
        LinkNode temp=cache.get(key);
        if(temp==null){
            if(cache.size()>=capacity){
                removeLastNode();
            }
            temp=new LinkNode();
            temp.key=key;
        }
        temp.val=value;
        moveNodeToFirst(temp);
        cache.put(key,temp);
    }

    private void removeLastNode(){
        LinkNode temp=last;
        last=last.pre;
        if(last!=null){
            last.next=null;
        }else{
            first=last=null;
        }
        cache.remove(temp.key);
    }

    private void moveNodeToFirst(LinkNode node){
        if(first==node) {return;}
        if(node.pre!=null){
            node.pre.next=node.next;
        }
        if(node.next!=null){
            node.next.pre=node.pre;
        }
        if(node==last){
            last=last.pre;
        }
        if(last==null){
            last=first=node;
            return;
        }
        node.next=first;
        first.pre=node;
        node.pre=null;
        first=node;
    }
}

    class LinkNode{
        LinkNode pre;
        LinkNode next;
        int key;
        int val;
    }

