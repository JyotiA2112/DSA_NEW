//package Tree;
//
//import org.junit.jupiter.api.BeforeEach;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class Test {
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @org.junit.jupiter.api.Test
//    public void testMethod()
//    {
//        LeastCommonAncestor lca = new LeastCommonAncestor();
//        TreeNode1 root = new TreeNode1(3);
//        root.left = new TreeNode1(5);
//        root.right = new TreeNode1(1);
//        root.left.left = new TreeNode1(6);
//        root.left.right = new TreeNode1(2);
//        root.right.left = new TreeNode1(0);
//        root.right.right = new TreeNode1(8);
//        root.left.right.left = new TreeNode1(7);
//        root.left.right.right = new TreeNode1(4);
//
//       // LeastCommonAncestor lca = new LeastCommonAncestor();
//
//
//        assertEquals(5,lca.lowestCommonAncestor(root, new TreeNode1(5),new TreeNode1(4)).val);
//
//    }
//
//}