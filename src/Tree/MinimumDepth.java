package Tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepth {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = minDepth2(root);
        System.out.println(result);
    }

    private static int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return 1 + minDepth(root.right);
        if(root.right == null)
            return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
    private static int minDepth2(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int depth = 1;
        while (!que.isEmpty()){
            int size = que.size();
            while (size-- > 0){
                TreeNode temp = que.poll();
                if(temp.left == null && temp.right == null){
                    return depth;
                }
                if(temp.left != null){
                    que.add(temp.left);
                }
                if(temp.right != null){
                    que.add(temp.right);
                }
            }
            depth++;
        }
        return 0;
    }


}
