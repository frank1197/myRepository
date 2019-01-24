package LeetCode.No199;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2018-07-17 17:02
 **/

import LeetCode.dataStructure.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Title: interviewTest
 * @Package LeetCode.No199
 * @Description: todo
 * @author yanfeng3
 * @date 2018/7/17 17:02
 * @version V1.0
 */
public class binaryTreeRightSide {

    public static void main(String[] args) {
        TreeNode binTree = new TreeNode();
        Object[] objs={0,1,2,3,4,5,6,7};
        binTree.createTree(objs);
        System.out.println(JSON.toJSON(binTree.getRoot()));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(root == null) {
            return list;
        }
        queue.add(root);

        while(!queue.isEmpty()) {
            int m = queue.size();
            while(m > 0) {
                TreeNode node = queue.remove();
                if(node.getlChild() != null) {
                    queue.add(node.getlChild());
                }
                if(node.getrChild() != null) {
                    queue.add(node.getrChild());
                }
                m--;
                if(m == 0) {
//                    list.add(node.val);
                }
            }
        }
        return list;
    }


}
