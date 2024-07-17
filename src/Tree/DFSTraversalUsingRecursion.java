package Tree;

import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

class Node{
    int val;
    Node left;
    Node right;

    Node(int val)
    {
        this.val = val;
    }

    Node(int val, Node left, Node right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
public class DFSTraversalUsingRecursion {

    static int traverseNode(Node node, int sum)
    {

        if(node.left!=null)
        {
            sum = traverseNode(node.left, sum); //2,0 //2,0 //
        }
        //traverseNode(node,sum);
        if(node.right != null)
        {
            sum = traverseNode(node.right, sum); //(3,0) // (4,7)

        }

        sum = sum + node.val; //3 //5 //9 //11
        return sum;

    }

    public static void main(String[] args) {

        Node node = new Node(3);
        node.left = new Node(2);
        node.left.left = new Node(2);
        node.left.left.right = new Node(3);
        node.left.right = new Node(4);
        node.right = new Node(7);
        node.right.right = new Node(8);
        node.right.right.left = new Node(6);

        System.out.println(traverseNode(node,0));



    }
}
