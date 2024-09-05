package code.Tree;

public class MaxBinaryTree {
}

class Solution {
    public TreeNode1 constructMaximumBinaryTree(int[] nums) {


        TreeNode1 root = constructBinaryTree(nums, 0, nums.length-1);



        return root;
    }

    private TreeNode1 constructBinaryTree(int[] nums, int start, int end) {

        if(start>end)
        {
            return null;
        }

        int maxIndex = findMaxRoot(nums,start,end);
        TreeNode1 root = new TreeNode1(nums[maxIndex]);
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
