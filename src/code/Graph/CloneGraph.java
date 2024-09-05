package code.Graph;


import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class CloneGraph {
    public Node cloneGraph(Node node) {

        Stack<Node> stack = new Stack();
        stack.push(node);
        Map<Integer, Node> nodeMap = new HashMap();
        Map<Integer,Boolean> visitedMap = new HashMap();

        while(!stack.isEmpty())
        {
            Node item = stack.pop();
            if(!visitedMap.containsKey(item.val))
            {
                visitedMap.put(item.val, true);
                List<Node> adj = item.neighbors;
                Node copyItem;
                if(nodeMap.containsKey(item.val))
                {
                    copyItem = nodeMap.get(item.val);
                }
                else{
                    copyItem = new Node(item.val, new ArrayList<Node>());
                    nodeMap.put(item.val,copyItem);
                    Set s = new HashSet();
                }

                for(int i=0; i < adj.size(); i++)
                {


                    if(nodeMap.containsKey(adj.get(i).val))
                    {

                        copyItem.neighbors.add(nodeMap.get(adj.get(i).val));
                    }
                    else{
                        //TODO - create a node and add it in adj list
                        Node newNode = new Node(adj.get(i).val, new ArrayList<Node>());
                        nodeMap.put(adj.get(i).val,newNode);
                        copyItem.neighbors.add(nodeMap.get(adj.get(i).val));
                    }





//TODO - check for boolean flag and
                    if(!visitedMap.containsKey(adj.get(i).val))
                        stack.push(adj.get(i));
                }
            }



        }

        return nodeMap.get(node.val);
    }


    public static void main(String[] args) {
        CloneGraph graph = new CloneGraph();
        Node n1 = new Node(1,new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n3 = new Node(3,new ArrayList<>());
        Node n4 = new Node(4,new ArrayList<>());


        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        graph.cloneGraph(n1);
    }
}
