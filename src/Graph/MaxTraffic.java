package Graph;

import java.util.*;

class GraphNew {

    List<NodeNew> nodes = new ArrayList<>();
    public void addNode(NodeNew n)
    {
        this.nodes.add(n);
    }
    List<NodeNew> getNodes(){
        return this.nodes;
    }

}
class NodeNew {
    int val;
    List<Integer> edges;
    NodeNew(int val)
    {
        this.val = val;
        edges = new ArrayList<>();
    }
    List<Integer> getEdges()
    {
        return this.edges;
    }
}
class MaxTraffic {
    public static String CityTraffic(String[] strArr) {
        // code goes here
        GraphNew g = new GraphNew();

        for(int i = 0; i< strArr.length; i++)
        {
            String s = strArr[i];
            String[] arr = s.split(":");
            int length = arr[1].length()-1;
            String neighbours = arr[1].substring(1,length);
            String[] neighbourArray = neighbours.split(",");
            NodeNew n = new NodeNew(Integer.parseInt(arr[0]));
            //System.out.println(n.val);
            for(int j=0; j < neighbourArray.length; j++)
            {
                n.getEdges().add(Integer.parseInt(neighbourArray[j]));
                //System.out.println(neighbourArray[j]);
            }

            g.addNode(n);
        }
        List<NodeNew> nodeList = g.getNodes();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<nodeList.size(); i++)
        {
            NodeNew n = nodeList.get(i);
            map.put(n.val, n.getEdges());
        }

        for(int i=0; i<nodeList.size(); i++)
        {
            Map<Integer, Boolean> tracker = new HashMap<>();

            NodeNew n = nodeList.get(i);
            tracker.put(n.val,true);
            List<Integer> edges = map.get(n.val);
            int max_traffic = 0;
            for(int j = 0; j< edges.size(); j++)
            {
                Integer weight = calculateWeight(edges.get(j),map,tracker);
                if(weight > max_traffic)
                {
                    max_traffic = weight;
                }
            }
            System.out.println(n.val+" : " + max_traffic);
        }

        return strArr[0];
    }
    public static Integer calculateWeight(Integer n, Map<Integer,List<Integer>> map, Map<Integer,Boolean> tracker)
    {
        //System.out.println(n);
        List<Integer> edges = map.get(n);
        int weight = n;
        for(int i =0 ; i< edges.size(); i++)
        {
            if(tracker.getOrDefault(edges.get(i), false) != true)
            {
                //System.out.println("coming here");
                tracker.put(n,true);//TODO - n,true
                weight = weight + calculateWeight(edges.get(i),map,tracker);
                //System.out.println(weight);
            }
        }
        return weight;

    }
    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String[] arr = new String[]{"1:[2,3]","2:[1]","3:[36,1]","36:[3]"};
        CityTraffic(arr);

    }
}
