package chap7_Tree;

/**
 * Rainbow
 *
 * @DATE:2023/10/25 0025
 */
public class ArrayBinaryTree {
    private int[] array;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    /**
     * 前序遍历
     * 1、先输出当前节点
     * 2、如果左子节点不为空，计算左子节点index并输出，递归左子节点
     * 3、如果右子节点不为空，计算右子节点的index并输出，递归右子节点
     */
    public void preOrder(int index) {
        //判断array是否为空
        if (array == null || array.length == 0) {
            return;
        }
        if (index >= 0 && array != null && array.length > index) {
            System.out.print(array[index] + " ");  //输出当前节点
            if (2 * index + 1 < array.length && 2 * index + 2 < array.length) {
                preOrder(2 * index + 1);      //递归左子节点
                preOrder(2 * index + 2);      //递归右子节点
            }
        }
    }

    /**
     * 中序遍历
     * 1、如果左子节点不为空，计算左子节点index并输出，递归左子节点
     * 2、输出当前节点
     * 3、如果右子节点不为空，计算右子节点的index并输出，递归右子节点
     */
    public void inOrder(int index) {
        //判断array是否为空
        if (array == null || array.length == 0) {
            return;
        }
        if (index >= 0 && array != null && array.length > index) {
            if (2 * index + 1 < array.length) {
                inOrder(2 * index + 1);      //递归左子节点
            }
            System.out.print(array[index] + " ");  //输出当前节点
            if (2 * index + 2 < array.length) {
                inOrder(2 * index + 2);      //递归右子节点
            }
        }
    }

    /**
     * 后续遍历
     * 1、如果左子节点不为空，计算左子节点index并输出，递归左子节点
     * 2、如果右子节点不为空，计算右子节点的index并输出，递归右子节点
     * 3、先输出当前节点
     */
    public void postOrder(int index) {
        //判断array是否为空
        if (array == null || array.length == 0) {
            return;
        }
        if (index >= 0 && array != null && array.length > index) {
            if (2 * index + 1 < array.length && 2 * index + 2 < array.length) {
                postOrder(2 * index + 1);      //递归左子节点
                postOrder(2 * index + 2);      //递归右子节点
            }
            System.out.print(array[index] + " ");  //输出当前节点
        }
    }
}
