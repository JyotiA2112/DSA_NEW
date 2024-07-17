package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node. */
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

class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack stack = new Stack();
        List<Integer> result = new ArrayList<Integer>();
        stack.peek();

        while(root!= null)
        {
            result.add(root.val);
            if(root.right != null)
            stack.push(root.right);

            if(root.left != null)
            stack.push(root.left);

            if(!stack.isEmpty())
            root = (TreeNode) stack.pop();
            else
                root = null;
        }


return result;

    }
}
