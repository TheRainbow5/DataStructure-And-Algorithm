package Basic.chap8_Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Rainbow
 * 基于链表实现二叉树
 * 利用前中后序实现树的遍历、查找
 *
 * @DATE:2023/7/24
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先创建一颗二叉树
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        //创建需要的节点
        Node<Integer> root = new Node<>(1);
        Node<Integer> node1 = new Node<>(2);
        Node<Integer> node2 = new Node<>(3);
        Node<Integer> node3 = new Node<>(4);
        Node<Integer> node4 = new Node<>(5);
        Node<Integer> node5 = new Node<>(6);
        //初始化二叉树
        binaryTree.setRoot(root);  //设置根节点
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        /**
         * 遍历
         */
        //测试前序遍历
        System.out.println("***前序遍历***");
        binaryTree.preOrder();
        //测试中序遍历
        System.out.println("***中序遍历***");
        binaryTree.inOrder();
        //测试后序遍历
        System.out.println("***后序遍历***");
        binaryTree.pastOrder();

        /**
         * 查找
         */
        System.out.println("*****查找*****");
        Node<Integer> integerNode = binaryTree.preOrderSearch(2);
        System.out.println(integerNode);

    }
}

/**
 * 作为根节点
 * 初始化二叉树root节点
 */
class BinaryTree<E> {
    private Node<E> root;

    //初始化roo节点
    public void setRoot(Node<E> root) {
        this.root = root;
    }

    /**
     * 遍历
     */
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

    /**
     * 查找
     */
    public Node<E> preOrderSearch(E target) {
        Node<E> resNode = null;
        //从根节点开始遍历
        if (this.root != null) {
            resNode = this.root.preOederSearch((E) target);
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
        return resNode;
    }
}

/**
 * 作为树的叶子节点
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class Node<T> {
    private T data;
    private Node left;  //默认null
    private Node right;  //默认null

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
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


    /**
     * 前序遍历查找
     * 1、先判断当前节点是否为目标节点
     * a、如果相等，返回节点
     * b、如果不相等，则判断左子节点是否为空，如果不为空，则左子节点继续递归前序查找
     * 2、如果左递归前序查找，找到节点，则返回；
     * 3、判断当前节点的右节点是否为空
     * a、如果为空，返回
     * b、如果不为空，继续
     *
     * @return
     */
    public Node<T> preOederSearch(T target) {
        //判断是否相等
        if (this.data.equals(target)) {
            return this;
        }
        Node<T> resNode = null;
        //向左递归
        if (this.left != null) {
            resNode = this.left.preOederSearch(target);
        }
        if (resNode != null) {    //找到节点后，就停止搜索（剪枝）
            return resNode;
        }
        //向有递归
        if (this.right != null) {
            resNode = this.right.preOederSearch(target);
        }
        return resNode;
    }

}



