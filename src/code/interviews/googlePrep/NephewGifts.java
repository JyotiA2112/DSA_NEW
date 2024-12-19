package code.interviews.googlePrep;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A kid found out that his uncle loves him so much that he would do anything to buy
 * him as many gifts as he possibly can. For this reason, the nephew prepares a list
 * of gifts that he wants and gives it to his uncle. Each item in the list contains
 * 2 integers: the day on which he wants the gift (today is day 0), and the cost of it.
 * The uncle, knowing that his nephew is preparing such a list, saves $1 per day for the gifts,
 * and initially (on day 0) he has $0.
 * Calculate the maximum number of gifts the uncle can buy to his nephew.
 *
 * First Test Case:
 *
 * Input
 *
 * 3
 *
 * 3 2
 *
 * 5 4
 *
 * 6 3
 *
 *
 * Output
 *
 * 2
 */
public class NephewGifts {

    static class Gift{
        int day;
        int cost;

        Gift(int day, int cost){
            this.day = day;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {

        Gift[] gifts = new Gift[]{
                new Gift(1,1),
                new Gift(50,40),
                new Gift(51,20),
                new Gift(52,20)};
        System.out.println(maxNoOfGifts(gifts));
    }

    public static int maxNoOfGifts(Gift[] arr){
        int maxMoney = Integer.MIN_VALUE;
        PriorityQueue<Gift> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        for(int i=0; i< arr.length; i++){
            maxMoney = Math.max(arr[i].day , maxMoney);
            pq.add(arr[i]);
        }




        int count = 0;


        while(!pq.isEmpty()){
            Gift g = pq.poll();

            if(g.cost <= maxMoney){
                maxMoney = maxMoney - g.cost;
                count++;
            }else{
                break;
            }


        }
        return count;
    }
}
