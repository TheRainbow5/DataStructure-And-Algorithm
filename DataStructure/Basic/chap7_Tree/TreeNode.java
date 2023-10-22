package chap7_Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Rainbow
 * 树的节点
 *
 * @DATE:2023/10/22 0022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode<T> {
    private T data;
    TreeNode left;   // 左子节点指针
    TreeNode right;  // 右子节点指针

    public TreeNode(T object) {
        this.data = object;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    /**
     * 前序遍历
     * 1、输出当前根节点
     * 2、如果左子节点不为空，递归调用前序遍历函数来遍历左子树。
     * 3、如果右子节点不为空，递归调用前序遍历函数来遍历历右子树。
     */
    public void preOrder() {
        System.out.print(data + " ");   //输出根节点
        //递归左子树
        if (left != null) {
            left.preOrder();
        }
        //递归右子树
        if (right != null) {
            right.preOrder();
        }
    }

    /**
     * 中序遍历
     * 1、如果当前节点的左子节点不为空，则递归调用中序遍历函数来遍历左子树。
     * 2、输出当前节点。
     * 3、如果当前节点的右子节点不为空，则递归调用中序遍历函数来遍历右子树。
     */
    public void inOrder() {
        //递归左子树
        if (left != null) {
            left.inOrder();
        }
        System.out.print(data + " ");   //输出根节点
        //递归右子树
        if (right != null) {
            right.inOrder();
        }
    }

    /**
     * 后序遍历
     * 1、如果当前节点的左子节点不为空，则递归调用后序遍历函数来遍历左子树。
     * 2、如果当前节点的右子节点不为空，则递归调用后序遍历函数来遍历右子树。
     * 3、输出当前节点。
     */
    public void postOrder() {
        //递归左子树
        if (left != null) {
            left.postOrder();
        }
        //递归右子树
        if (right != null) {
            right.postOrder();
        }
        System.out.print(data + " ");   //输出根节点
    }
}

