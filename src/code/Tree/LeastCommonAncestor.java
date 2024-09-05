
package code.Tree;

import  java.util.ArrayList;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LeastCommonAncestor {
    public TreeNode1 lowestCommonAncestor(TreeNode1 root, TreeNode1 p, TreeNode1 q) {
        ArrayList<TreeNode1>list1 = new ArrayList<>();
        ArrayList<TreeNode1>list2 = new ArrayList<>();
        nodeToRootPath_(root,p.val,list1);
        nodeToRootPath_(root,q.val,list2);

        int i=list1.size()-1;
        int j=list2.size()-1;
        TreeNode1 prev = null;
        while(i>=0 && j>=0){

            if(list1.get(i).val != list2.get(j).val) break;

            prev = list1.get(i);
            i--;
            j--;
        }
        return prev;
    }

    public boolean nodeToRootPath_(TreeNode1 root, int data, ArrayList<TreeNode1>path){
        if(root==null) return false;
        if(root.val==data){
            path.add(root);
            return true;
        }

        boolean lp = nodeToRootPath_(root.left, data, path);
        if(lp){
            path.add(root);
            return true;
        }
        boolean rp = nodeToRootPath_(root.right, data, path);
        if(rp){
            path.add(root);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(3);
        root.left = new TreeNode1(5);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(6);
        root.left.right = new TreeNode1(2);
        root.right.left = new TreeNode1(0);
        root.right.right = new TreeNode1(8);
        root.left.right.left = new TreeNode1(7);
        root.left.right.right = new TreeNode1(4);

        LeastCommonAncestor lca = new LeastCommonAncestor();


        TreeNode1 node = lca.lowestCommonAncestor(root, new TreeNode1(5),new TreeNode1(4));
        System.out.println(node.val);
    }
}
