package chap7_Tree;

/**
 * Rainbow
 *
 * @DATE:2023/10/22 0022
 */
public class BinaryTree<T> {
    private TreeNode<T> root;   //根节点

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if (this.root != null) {
            this.root.inOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 前序搜索
     *
     * @param value 要查找的值
     * @return
     */
    public TreeNode<T> preSearch(T value) {
        if (this.root != null) {    //root节点不为空
            return root.preSearch(value);
        } else {
            return null;
        }
    }

    /**
     * 中序搜素
     */
    public TreeNode<T> inSearch(T value) {
        if (this.root != null) {
            return root.inSearch(value);
        } else {
            return null;
        }
    }

    /**
     * 后序搜索
     */
    public TreeNode<T> postSearch(T value) {
        if (this.root != null) {
            return root.postSearch(value);
        } else {
            return null;
        }
    }
}
