package src.Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.
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
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {


        Queue<TreeNode> q = new LinkedList();

        if(root != null)
        {
            q.add(root);
            return printNode(q);
        }
        else{
            return null;
        }

    }

    List<List<Integer>> printNode(Queue q)
    {
        List<List<Integer>> list= new ArrayList<>();
        while(q != null)
        {
            int currentLevelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i =0; i< currentLevelSize; i++)
            {

                TreeNode data = (TreeNode) q.poll();
                currentLevel.add(data.val);
                if(data.left != null)
                {
                    q.offer(data.left);
                }
                if(data.right!= null)
                {
                    q.add(data.right);
                }
            }

list.add(currentLevel);
        }


return list;
    }
}
