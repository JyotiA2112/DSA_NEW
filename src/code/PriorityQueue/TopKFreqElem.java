package code.PriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFreqElem {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }


        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(pq.size() == k)
            {
                if(entry.getValue() > pq.peek().getValue())
                {
                    pq.poll();
                    pq.add(entry);
                }
            }
            else{
                pq.add(entry);
            }

        }


        int[] result = new int[k];
        int count = 0;
        while(pq.size() != 0)
        {
            result[count] = pq.poll().getKey();
        }

        return result;

    }
}