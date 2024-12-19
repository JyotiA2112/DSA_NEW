package code.interviews.googlePrep;

import com.sun.source.tree.Tree;

/**
 *
 * Given a tree, calculate the maximum ancestor for all the leaf nodes. Maximum ancestor of a leaf node is the maximum of it's ancestors and the leaf itself.
 *
 * Example:
 *
 * 		    4
 * 	      /  \
 *      5     3
 *     /     / \
 *    1     2   6
 *
 * Output -
 * 1: 5
 * 2: 4
 * 6: 6
 */

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val,TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MapLeafToMaxAncestor {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(5, new TreeNode(1,null,null),null);
        TreeNode right = new TreeNode(3, new TreeNode(2,null,null), new TreeNode(6, null, null));

        TreeNode root = new TreeNode(4, left, right);
        findMapping(root, root.val);


    }

    public static void findMapping(TreeNode root, int maxSoFar){


            if(root.left != null){
                findMapping(root.left, Math.max(root.left.val , maxSoFar));
            }
            if(root.right != null){

                findMapping(root.right, Math.max(root.right.val , maxSoFar));
            }
            if(root.left == null && root.right == null){
                System.out.println("Mapping : "+root.val+"-"+maxSoFar);
            }




    }

}
