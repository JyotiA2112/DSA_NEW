package Tree;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class Test {

    @BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    public void testMethod()
    {
        LeastCommonAncestor lca = new LeastCommonAncestor();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

       // LeastCommonAncestor lca = new LeastCommonAncestor();


        assertEquals(5,lca.lowestCommonAncestor(root, new TreeNode(5),new TreeNode(4)).val);

    }

}