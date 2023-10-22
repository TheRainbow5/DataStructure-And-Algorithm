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
        TreeNode<String> root = new TreeNode<>("宋江");   //根节点
        TreeNode<String> node2 = new TreeNode<>("吴用");
        TreeNode<String> node3 = new TreeNode<>("林冲");
        TreeNode<String> node4 = new TreeNode<>("卢俊义");

        //手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        binaryTree.setRoot(root);

        //遍历二叉树
        root.preOrder();  //前序遍历
        root.inOrder();   //中序遍历
        root.postOrder(); //后序遍历
    }
}
