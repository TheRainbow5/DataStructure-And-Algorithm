package Basic.chap7_Tree;

/**
 * Rainbow
 *
 * @DATE:2023/7/17 0017
 */
public class LinkedListTree<T> {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        LinkedListTree<Integer> linkedListTree = new LinkedListTree<>();
        linkedListTree.initTree(arr);

    }

    public void initTree(T[] arr) {
        //第一个为根节点
        for (int i = 0; i < arr.length; i++) {
            System.out.println("===" + arr[i] + "===");
            TreeNode treeNode = new TreeNode((Integer) arr[i]);
            treeNode.left = new TreeNode((Integer) arr[i + 1]);
            treeNode.right = new TreeNode((Integer) arr[i + 1]);

        }
    }

    /**
     * 遍历树---层序遍历（广度优先搜索）
     * 1、循环每个一层
     * 2、从顶部到底部逐层遍历二叉树，并在每一层按照从左到右的顺序访问节点
     * 可以采用队列（先进先出）结构访问数据的顺序。
     */
    public void LevelOrderTraversal(TreeNode root) {

    }

    /* 二叉树节点类 */
    class TreeNode {
        int value;         // 节点值
        TreeNode left;   // 左子节点指针
        TreeNode right;  // 右子节点指针

        TreeNode(int x) {
            value = x;
        }
    }
}
