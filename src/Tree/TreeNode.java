package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, TreeNode _left, TreeNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public void levelOrderTraversal(TreeNode root){
        if (root == null)
            return;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()){
            TreeNode temp = que.poll();
            if(temp.left != null)
                que.add(temp.left);
            if (temp.right != null)
                que.add(temp.right);
            System.out.print(temp.val+" ");
        }
    }
    public void inOrderTraversal(TreeNode root){
        if(root == null) return;
        if(root.left != null) inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        if(root.right != null) inOrderTraversal(root.right);
    }
    public void preOrderTraversal(TreeNode root){
        if(root == null) return;
        System.out.print(root.val+" ");
        if(root.left != null) preOrderTraversal(root.left);
        if(root.right != null) preOrderTraversal(root.right);
    }
    public void postOrderTraversal(TreeNode root){
        if(root == null) return;
        if(root.left != null) postOrderTraversal(root.left);
        if(root.right != null) postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }
//    public void insert(TreeNode root, int item){
//        TreeNode temp = new TreeNode(item);
//        if(root == null){
//            root = temp;
//        }
//        else{
//            insert(root.left, item);
//        }
//    }
}
