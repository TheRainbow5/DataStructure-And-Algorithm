package Advanced.chap8_Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Rainbow
 * 基于链表实现二叉树
 *
 * @DATE:2023/7/24 0024
 */


public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        //初始化二叉树
        binaryTree.setRoot(root);  //设置根节点
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        //测试前序遍历
        System.out.println("***前序遍历***");
        binaryTree.preOrder();
        //测试中序遍历
        System.out.println("***中序遍历***");
        binaryTree.inOrder();
        //测试后序遍历
        System.out.println("***后序遍历***");
        binaryTree.pastOrder();

    }
}

/**
 * 作为根节点
 * 初始化二叉树root节点
 */
class BinaryTree {
    private Node root;

    //初始化roo节点
    public void setRoot(Node root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        //从根节点开始遍历
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void inOrder() {
        //从根节点开始
        if (this.root != null) {
            this.root.inOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void pastOrder() {
        //从根节点开始
        if (this.root != null) {
            this.root.pastOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}

/**
 * 作为树的叶子节点
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class Node {
    private int data;
    private Node left;  //默认null
    private Node right;  //默认null

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new String(String.valueOf(this.data));
    }

    /**
     * 前序遍历
     * 1、先输出当前节点（初始为roo节点）
     * 2、如果左子节点不为空，则递归继续遍历
     * 3、如果右字节点不为空，则递归继续遍历
     * 所有节点都访问一次，T(n)=O(n)
     */
    public void preOrder() {
        System.out.println(this.data);  //先输出父节点
        //递归向左子树
        if (this.left != null) {
            this.left.preOrder();  //递归
        }
        //递归向右子树
        if (this.right != null) {
            this.right.preOrder(); //递归
        }
    }

    /**
     * 中序遍历
     * 1、如果左子节点不为空，则递归继续遍历
     * 2、输出当前节点
     * 3、如果右字节点不为空，则递归继续遍历
     * 所有节点都访问一次，T(n)=O(n)
     */
    public void inOrder() {
        //递归左子树
        if (this.left != null) {
            this.left.inOrder();
        }
        //输出当前节点
        System.out.println(this.data);
        //递归向右子树
        if (this.right != null) {
            this.right.inOrder();
        }
    }

    /**
     * 1、如果左节点不为空，则继续递归遍历
     * 2、如果右节点不为空，则继续递归遍历
     * 3、输出当前节点
     * 所有节点都访问一次，T(n)=O(n)
     */
    public void pastOrder() {
        //递归左子树
        if (this.left != null) {
            this.left.inOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.inOrder();
        }
        //输出当前节点
        System.out.println(this.data);
    }
}



