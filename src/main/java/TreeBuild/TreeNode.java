package TreeBuild; /**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2018-06-21 17:18
 **/

import java.util.List;

/**
 * @Title: buildTree
 * @Package PACKAGE_NAME
 * @Description: todo
 * @author yanfeng3
 * @date 2018/6/21 17:18
 * @version V1.0
 */
public class TreeNode {

    private String id;

    private String parentId;

    private String name;

    private List<TreeNode> children;

    public TreeNode(String id, String name, String parentId) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }
    public TreeNode(String id, String name, TreeNode parent) {
        this.id = id;
        this.parentId = parent.getId();
        this.name = name;
    }


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "id='" + id + '\'' +
            ", parentId='" + parentId + '\'' +
            ", name='" + name + '\'' +
            ", children=" + children +
            '}';
    }

}