package code.Graph;

import java.util.*;

//This program checks if a direct graph is strongly connected or not.
public class CheckIfConnectedGraph {

    static class Graph{
        Map<String, List<String>> edges;

        Graph(){
            this.edges = new HashMap<>();
        }

        public void addVertex(String v)
        {
            this.edges.put(v,new ArrayList<>());
        }

        public void addEdge(String source, String dest)
        {
            this.edges.get(source).add(dest);
        }

        public Graph transposeGraph()
        {
            Graph transposedGraph = new Graph();
            for(Map.Entry<String,List<String>> entry : this.edges.entrySet())
            {
                    String vertex = entry.getKey();
                    List<String> edges = entry.getValue();

                    for(int v=0; v < edges.size(); v++)
                    {
                        if(transposedGraph.edges.containsKey(edges.get(v)))
                        {
                            transposedGraph.addEdge(edges.get(v),vertex);
                        }else{
                            transposedGraph.addVertex(edges.get(v));
                            transposedGraph.addEdge(edges.get(v),vertex);
                        }
                    }
            }
        return transposedGraph;

        }



    }




    public static void main(String[] args) {

        CheckIfConnectedGraph checkIfConnectedGraph = new CheckIfConnectedGraph();
        String vertex = "0";

        Graph g1 = new Graph();

        g1.addVertex("0");
        g1.addVertex("1");
        g1.addVertex("2");
        g1.addVertex("3");
        g1.addVertex("4");


        g1.addEdge("0", "1");
        g1.addEdge("1", "2");
        g1.addEdge("2", "3");
        g1.addEdge("3", "0");
        g1.addEdge("2", "4");
        g1.addEdge("4", "2");


        //boolean checkIfGraphConnected = checkIfGraphConnected(g1, vertex);
        //boolean checkIfTransposedGraphConnected = checkIfGraphConnected(g1.transposeGraph(), vertex);

        if(checkIfGraphConnected(g1, vertex) && checkIfGraphConnected(g1.transposeGraph(), vertex))
        {
            System.out.println("Connected");
        }
        else{
            System.out.println("Not Connected");
        }

    }

    private static boolean checkIfGraphConnected(Graph graph, String vertex) {

        Stack<String> stack = new Stack();
        stack.push(vertex);

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(vertex,true);
        while(! stack.isEmpty())
        {
            String data = stack.pop();
            if(graph.edges.containsKey(data))
            graph.edges.get(data).forEach(data1 -> {
                if(!visited.containsKey(data1))
                {
                    stack.push(data1);
                    visited.put(data1,true);
                }
            });


        }

        return visited.size() == graph.edges.size();

    }

}
