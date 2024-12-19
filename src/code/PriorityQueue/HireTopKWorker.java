package code.PriorityQueue;


import java.util.PriorityQueue;

class HireTopKWorker {
    public long totalCost(int[] costs, int k, int candidates) {

        //PriorityQueue<Integer> pq = new PriorityQueue<>(a,b -> (b-a));
        PriorityQueue<Integer> first = new PriorityQueue<Integer>((a, b) -> a-b);
        PriorityQueue<Integer> second = new PriorityQueue<Integer>((a,b) -> a-b);

        int hired = 0;
        int[] hiredCand = new int[k];
        int pointer1 = candidates-1;
        int pointer2 = costs.length-candidates;

        for(int i=0; i<candidates; i++){
            first.add(costs[i]);
        }

        for(int i=costs.length-1; i>=costs.length-candidates; i--){
            second.add(costs[i]);
        }

        while(hired != k){
            int item;
            if(first.peek() <= second.peek()){
                item = first.poll();
                pointer1++;
                //if(pointer1 < costs.length)first.add(costs[pointer1]);
            }else{
                item = second.poll();
                pointer2--;
                //if(pointer2 >= 0)second.add(costs[pointer2]);

            }
            hiredCand[hired] = item;
            hired++;
        }

        long sum = 0;
        for(int i=0; i<hiredCand.length; i++){
            sum += hiredCand[i];
        }

        return sum;


    }

    public static void main(String[] args) {
        HireTopKWorker hire = new HireTopKWorker();
        hire.totalCost(new int[]{1,2,4,1} ,3, 3);
    }
}