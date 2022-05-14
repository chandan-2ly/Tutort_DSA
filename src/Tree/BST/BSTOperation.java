package Tree.BST;

import Tree.TreeNode;

//https://www.techiedelight.com/deletion-from-bst/
public class BSTOperation {
    public static void main(String[] args){
        int[] array = {5,3,6,2,4,7};
        TreeNode root = null;
        for(int i  = 0; i < array.length; i++){
            root = insertBST(root, array[i]);
        }
        TreeNode.inOrderTraversal(root);
        System.out.println();
        int key = 5;
        boolean result = searchBST(root, key);
        System.out.println(result);
        root = deleteBST(root, key);
        TreeNode.inOrderTraversal(root);
    }

    private static TreeNode insertBST(TreeNode root, int elem){
        if (root == null){
            return  new TreeNode(elem);
        }
        if(elem < root.val)
            root.left = insertBST(root.left, elem);
        else {
            root.right = insertBST(root.right, elem);
        }

        return root;
    }

    private static boolean searchBST(TreeNode root, int key) {
        if (root == null) return false;
        if(root.val == key) return true;
        if (key < root.val){
            return searchBST(root.left, key);
        }
        else return searchBST(root.right, key);
    }

    private static TreeNode deleteBST(TreeNode root, int key) {
        if (root == null) return root;

        TreeNode parent = null;
        TreeNode curr = root;

        while (curr != null && curr.val != key){
            parent = curr;
            if(key < curr.val)
                curr = curr.left;
            else curr = curr.right;
        }

        if(curr == null) return root;
        //case 1
        if(curr.left == null && curr.right == null){
            if(curr == root){
                root = null;
                return root;
            }
            else{
                if(parent.left == curr){
                    parent.left = null;
                }
                else parent.right = null;
            }
        }
        //case 2
        else if(curr.left != null && curr.right != null){
            TreeNode successor = getMinimumKey(curr.right);
            int value = successor.val;
            deleteBST(root, successor.val);

            curr.val = value;
        }
        //case 3
        else {
            TreeNode child = curr.left != null ? curr.left : curr.right;

            if(curr == root){
                root = child;
            }
            else {
                if (curr == parent.left){
                    parent.left = child;
                }
                else {
                    parent.right = child;
                }
            }
        }
        return root;
    }

    private static TreeNode getMinimumKey(TreeNode curr) {
        while (curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
}
