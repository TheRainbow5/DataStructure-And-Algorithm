import chap7_Tree.ArrayBinaryTree;
import chap7_Tree.BinaryTree;
import chap7_Tree.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * Rainbow
 *
 * @DATE:2023/10/22 0022
 */
public class APP {
    @Test
    public void testBinaryTree() {
        //创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建树节点
        TreeNode<Integer> root = new TreeNode<>(1);   //根节点
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);

        //手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        binaryTree.setRoot(root);  //设置为根节点

        /**
         *遍历二叉树
         */
        System.out.print("前序遍历：");
        root.preOrder();  //前序遍历
        System.out.println();
        System.out.print("中序遍历：");
        root.inOrder();   //中序遍历
        System.out.println();
        System.out.print("后序遍历：");
        root.postOrder(); //后序遍历
        System.out.println();
        /**
         * 搜索二叉树
         */
        TreeNode<Integer> pn = root.preSearch(1);
        System.out.println(pn);

        TreeNode<Integer> psn = root.postSearch(2);
        System.out.println(psn);

        TreeNode<Integer> in = root.postSearch(3);
        System.out.println(in);

        /**
         * 删除二叉树
         */
        binaryTree.remove(2);
        System.out.print("前序遍历：");
        root.preOrder();  //前序遍历
        System.out.println();
        System.out.print("中序遍历：");
        root.inOrder();   //中序遍历
        System.out.println();
        System.out.print("后序遍历：");
        root.postOrder(); //后序遍历
        System.out.println();
    }

    /**
     * 测试顺序二叉树
     */
    @Test
    public void testABT() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree abt = new ArrayBinaryTree(arr);
        System.out.print("前序遍历：");
        abt.preOrder(0);
        System.out.println();
        System.out.print("中序遍历：");
        abt.inOrder(0);
        System.out.println();
        System.out.print("后序遍历：");
        abt.postOrder(0);
    }
}
