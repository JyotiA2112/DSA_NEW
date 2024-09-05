package code.PriorityQueue;

import java.util.*;


class WaitTime {

    /*
     * Complete the 'findRequestsInQueue' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY wait as parameter.
     */

    static class Item{
        int index;
        int waitTime;

        Item(int index, int waitTime)
        {
            this.index = index;
            this.waitTime = waitTime;
        }
    }

    static class ItemComparator implements Comparator<Item>
    {
        public int compare(Item a, Item b)
        {
            return Integer.compare(a.waitTime, b.waitTime);
        }
    }

    public static List<Integer> findRequestsInQueue(List<Integer> wait) {
        // Write your code here

            char[] c= {'q'};
            String s = String.valueOf(c);


        PriorityQueue<Item> pq= new PriorityQueue<Item>(wait.size(), new ItemComparator());
        List<Integer> reqList = new ArrayList<>();
        for(int i=0; i < wait.size(); i++)
            pq.add(new Item(i,wait.get(i)));

        for(int i=0; i<wait.size();i++)
        {

            reqList.add(pq.size());
            List<Item> items = new ArrayList<>();
            while(!pq.isEmpty())
            {
                Item item = pq.poll();
                if(item.waitTime > i+1 && item.index != i)
                    items.add(item);
            }
            items.forEach(item -> pq.add(item));



        }

        return reqList;
    }


    public static void main(String[] args) {
        List<Integer> waitTime = Arrays.asList(2,2,3,1);
        WaitTime wt = new WaitTime();
        findRequestsInQueue(waitTime);

    }

}



