

package code.Graph;

import java.util.*;

class Graph1<T>{

    //T t;
    Map<T,List<Edge>> map = new Hashtable<>();


    public void addVertex(T t)
    {
        this.map.put(t,new ArrayList<Edge>());
        //Collections.sort(map);
    }

    public void addEdge(T source, T destination, int weight)
    {
        if(map.containsKey(source) && map.containsKey(destination))
        {
            map.get(source).add(new Edge(destination,weight));
        }
    }

    public List<Edge> getEdge(T t)
    {
        return map.get(t);
    }

}

class Edge<T>{
    T destination;
    int weight;

    Edge(T destination, int weight)
    {
        this.destination = destination;
        this.weight = weight;
    }

}

class IntermediateNode{
    String s;
    int distance;

    IntermediateNode(String s, int dis)
    {
        this.distance = dis;
        this.s = s;
    }


}
public class ShortestPath {

    public static void main(String[] args) {
        Graph1 g = new Graph1();
        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("f");
        g.addVertex("e");

        g.addEdge("a","b",5);
        g.addEdge("b","e",2);
        g.addEdge("b","f",6);
        g.addEdge("e","f",10);
        g.addEdge("e","c",3);

        ShortestPath.findShortestPath("a","f",g);

    }


    public static void findShortestPath(String source, String destination, Graph1 g)
    {

        int minimumDistance = Integer.MAX_VALUE;




        Stack<IntermediateNode> stack = new Stack();
        stack.push(new IntermediateNode(source,0));

        while(!stack.isEmpty())
        {
            IntermediateNode node = stack.pop();
            //stack.peek()
            List<Edge> edges = g.getEdge(node.s);
            for(Edge edge : edges)
            {
                int dist = node.distance+ edge.weight;
                if(edge.destination == destination)
                {
                    minimumDistance = Math.min(minimumDistance,dist);
                }
                stack.push(new IntermediateNode((String)edge.destination,dist));
            }
        }

        System.out.println(minimumDistance);

    }




}
