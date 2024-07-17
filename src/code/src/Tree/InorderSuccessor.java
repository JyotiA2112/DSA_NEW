//package src.Tree;
//
//public class InorderSuccessor {
//
//    public void findInorderSuccessor()
//    {
//        Node curr = inputNode;
//        if(curr.right!= null)
//        {
//            curr = curr.right;
//            while(curr != null && curr.left != null)
//            {
//                curr = curr.left;
//            }
//            return curr;
//        }
//
//        else
//        {
//
//            curr = curr.parent;
//            if(curr.key > inputNode.key)
//                return curr;
//            else
//            {
//                System.out.println("Coming here"+inputNode.key);
//                curr = curr.parent;
//                while(curr != null)
//                {
//                    if(curr.key > inputNode.key)
//                    {
//                        return curr;
//                    }
//                    curr = curr.parent;
//                }
//                return curr;
//            }
//        }
//
//    }
//}
//
//
