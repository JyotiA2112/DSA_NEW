package code.interviews;

public class WM2 {

    public int findProfit(int[] arr)
    {
        int profit = 0;
        int profitIfSoldToday  = 0;
        int pp = Integer.MAX_VALUE; //1000
        for(int i =0; i<arr.length; i++)
        {
            if(arr[i] < pp)
            {
                pp = arr[i];
            }
            profitIfSoldToday = arr[i] - pp; // 1-7 //5-1 //3-5
            if(profitIfSoldToday > profit)
            {
                profit = profitIfSoldToday;
            }

        }

        return profit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        WM2 wm2 = new WM2();
        System.out.println(wm2.findProfit(arr));
    }
}

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
* */
