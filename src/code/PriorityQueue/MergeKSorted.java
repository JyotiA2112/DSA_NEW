package code.PriorityQueue;//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

class MergeKSorted{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();
            Solution T = new Solution();
            ArrayList<Integer> arr= T.mergeKArrays(a, n);
            for(int i = 0; i < n*n ; i++)
                System.out.print(arr.get(i)+" ");
            System.out.println();

            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Node{
    int item;
    int index;
    int inputArrayIndex;

    public Node(int item,int index,int inputArrayIndex)
    {
        this.item = item;
        this.index = index;
        this.inputArrayIndex = inputArrayIndex;
    }
}

class ItemComparator implements Comparator<Node>{

    public int compare(Node a, Node b){
        return Integer.compare(a.item, b.item);
    }

}
class ItemComparable implements Comparable<Node>{

    public int compareTo(Node a){
        return this.compareTo(a);
    }

}

class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K)
    {
        // Write your code here.
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new ItemComparator());
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<K; i++)
        {
            Node n = new Node(arr[i][0], 0, i);
            pq.add(n);
        }

        while(!pq.isEmpty())
        {
            Node node = pq.poll();
            list.add(node.item);

            int index = node.index;
            int inputArrayIndex = node.inputArrayIndex;
            int size = arr[inputArrayIndex].length;

            if(index+1 < size)
            {
                Node n = new Node(arr[inputArrayIndex][index+1], index+1, inputArrayIndex);
                pq.add(n);
            }
        }


        return (ArrayList<Integer>) list;





    }
}