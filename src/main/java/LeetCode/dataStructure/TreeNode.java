package LeetCode.dataStructure;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2018-07-17 16:50
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: interviewTest
 * @Package LeetCode.dataStructure
 * @Description: todo
 * @author yanfeng3
 * @date 2018/7/17 16:50
 * @version V1.0
 */
public class TreeNode {

    //左孩子
    private TreeNode lChild;
    //右孩子
    private TreeNode rChild;
    //根节点
    private TreeNode root;

    public TreeNode getlChild() {
        return lChild;
    }

    public void setlChild(TreeNode lChild) {
        this.lChild = lChild;
    }

    public TreeNode getrChild() {
        return rChild;
    }

    public void setrChild(TreeNode rChild) {
        this.rChild = rChild;
    }

    //数据域
    private Object data;
    //存储所有的节点
    private List<TreeNode> datas;
    public TreeNode(TreeNode lChild, TreeNode rChild, Object data) {
        super();
        this.lChild = lChild;
        this.rChild = rChild;
        this.data = data;
    }
    public TreeNode(Object data) {
        this(null, null, data);
    }
    public TreeNode() {
        super();
    }

    public void createTree(Object[] objs){
        datas=new ArrayList<TreeNode>();
        for (Object object : objs) {
            datas.add(new TreeNode(object));
        }
        root=datas.get(0);//将第一个作为根节点
        for (int i = 0; i < objs.length/2; i++) {
            datas.get(i).lChild=datas.get(i*2+1);
            if(i*2+2<datas.size()){//避免偶数的时候 下标越界
                datas.get(i).rChild=datas.get(i*2+2);
            }
        }
    }
    //先序遍历
    public void preorder(TreeNode root){
        if(root!=null){
            visit(root.getData());
            preorder(root.lChild);
            preorder(root.rChild);
        }

    }
    //中序遍历
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.lChild);
            visit(root.getData());
            inorder(root.rChild);
        }

    }
    //后序遍历
    public void afterorder(TreeNode root){
        if(root!=null){
            afterorder(root.lChild);
            afterorder(root.rChild);
            visit(root.getData());
        }

    }
    private void visit(Object obj) {
        System.out.print(obj+" ");
    }
    public Object getData() {
        return data;
    }
    public TreeNode getRoot() {
        return root;
    }



}
