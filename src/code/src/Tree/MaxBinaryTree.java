package Tree;

public class MaxBinaryTree {
}


 //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {


        TreeNode root = constructBinaryTree(nums, 0, nums.length-1);



        return root;
    }

    private TreeNode constructBinaryTree(int[] nums, int start, int end) {

        if(start>end)
        {
            return null;
        }

        int maxIndex = findMaxRoot(nums,start,end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructBinaryTree(nums,start,maxIndex-1);
        root.right = constructBinaryTree(nums,maxIndex+1,end);

        return root;

    }


    private Integer findMaxRoot(int[] nums,int start, int end) {

        int maxIndex = nums.length;
        int maxNode = Integer.MIN_VALUE;
        for(int i=start; i<=end; i++)
        {
            if(nums[i] >= maxNode)
            {
                maxNode = nums[i];
                maxIndex = i;
            }

        }
        return maxIndex;
    }
}
