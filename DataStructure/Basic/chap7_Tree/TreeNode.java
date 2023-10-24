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
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归右子树
        if (this.right != null) {
            this.right.preOrder();
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
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归右子树
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.print(data + " ");   //输出根节点
    }


    /**
     * 前序搜索
     * 1、先判断当前节点是否等于目标节点，如果相等，则返回当前节点
     * 2、如果当前节点的左子节点不为空，则递归调用前序搜索函数来搜索左子树，找到则返回。
     * 3、如果当前节点的右子节点不为空，则递归调用前序搜索函数来搜索右子树，找到则返回。
     */
    public TreeNode<T> preSearch(T data) {
        TreeNode<T> resultNode = null;   //存储搜索的节点
        //判断当前节点是否为目标节点
        if (this.data.equals(data)) {
            return this;
        }
        if (this.left != null) {
            resultNode = this.left.preSearch(data);  //左节点递归搜索
        }
        if (resultNode == null && this.right != null) {  //左子节点没有找到
            resultNode = this.right.preSearch(data);  // 右节点递归搜索
        }
        return resultNode;
    }

    /**
     * 中序搜索
     * 1、如果当前节点的左子节点不为空，则递归调用前序搜索函数来搜索左子树，找到则返回。
     * 2、先判断当前节点是否等于目标节点，如果相等，则返回当前节点
     * 3、如果当前节点的右子节点不为空，则递归调用后序搜索函数来搜索右子树，找到则返回。
     */
    public TreeNode<T> inSearch(T value) {
        TreeNode<T> resultNode = null;
        if (this.left != null) {
            resultNode = this.left.inSearch(value);
        }
        if (this.data.equals(value) && resultNode == null) {
            resultNode = this;
        }
        if (this.right != null && resultNode == null) {
            resultNode = this.right.inSearch(value);
        }
        return resultNode;
    }

    /**
     * 后序搜索
     * 1、如果当前节点的左子节点不为空，则递归调用前序搜索函数来搜索左子树，找到则返回。
     * 2、如果当前节点的右子节点不为空，则递归调用后序搜索函数来搜索右子树，找到则返回。
     * 3、先判断当前节点是否等于目标节点，如果相等，则返回当前节点
     */
    public TreeNode<T> postSearch(T value) {
        TreeNode<T> resultNode = null;   //存储搜索的节点

        if (this.left != null) {
            resultNode = this.left.postSearch(value);  //左节点递归搜索
        }
        if (resultNode == null && this.right != null) { //左子节点找到，就不进行右递归
            resultNode = this.right.postSearch(value); // 右节点递归搜索
        }
        //判断当前节点是否为目标节点
        if (this.data.equals(value) && resultNode == null) {
            resultNode = this;
        }
        return resultNode;
    }

    /**
     * 删除节点（广度优先搜索）
     * 判断root节点是否为目标节点，不是则递归查找，是则返回
     * 1、判断当前节点的子节点是否为目标节点
     * 2、如果左子节点不为空，
     * 2.1、左子节点是目标节点，则this.left=null，结束递归。
     * 2.2、左子节点不是目标节点，则继续递归左子树，直到找到。
     * 如果左子节点都不是目标节点，则递归右子树。
     * 3、如果右子节点不为空，
     * 3.1、右子节点是目标节点，则this.right=null，结束递归。
     * 3.2、右子节点不是目标节点，则继续递归右子树，直到找到。
     */
    public void remove(T value) {
        //左子树不为空
        if (this.left != null && this.left.data.equals(value)) {
            this.left = null;
        }
        //右子树不为空
        if (this.right != null && this.right.data.equals(value)) {
            this.right = null;
        }
        //递归查找左子树
        if (this.left != null) {
            this.left.remove(value);
        }
        //递归查找右子树
        if (this.right != null) {
            this.right.remove(value);
        }

    }
}

