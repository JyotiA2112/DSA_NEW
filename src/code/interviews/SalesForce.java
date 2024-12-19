package code.interviews;

import java.util.Arrays;

/*

Description
An investor has saved some money and wants to invest in the stock market. There are a number of stocks to choose from, and they want to buy at most 1 share in any company. The total invested cannot exceed the funds available. A friend who is a stock market expert has predicted the values of each stock after 1 year. Determine the maximum profit that can be earned at the end of the year assuming the predictions come true.



Example

saving = 250

currentValue = [175, 133, 109, 210, 97]

futureValue = [200, 125, 128, 228, 133]



To maximize profits, the investor should buy stocks at indices 2 and 4 for an investment of 109 + 97 = 206. At the end of the year the stocks are sold for 128 + 133 = 261, so total profit is 261 - 206 = 55.

 */
public class SalesForce {

    public static void main(String[] args) {
       /* present: [1, 2, 3]
        future: [2, 3, 5]
        budget: 5*/
       System.out.println(maximumProfit(new int[]{175, 133, 109, 210, 97}, new int[]{200, 125, 128, 228, 133}, 250));
    }

    public static int returnMaxProfit(int[] currentVal, int[] futureVal, int savings){

        int[][]  profitDP = new int[currentVal.length+1][savings+1];
        int[] profit = new int[currentVal.length];

        for(int i=0; i<currentVal.length; i++){
            profit[i] = futureVal[i] - currentVal[i];
        }

        Arrays.sort(profit);

        for(int i=0 ; i<=currentVal.length; i++){
            for(int j=0; j<=savings; j++){
                if(j==0 || i==0){
                    profitDP[i][j] = 0;
                    continue;
                }
                int currBudget = j;
                int currCost = currentVal[i-1];
                if(currBudget >= currCost){

                    profitDP[i][j] = Math.max(profitDP[i-1][j],profit[i-1]+profitDP[i-1][currBudget-currCost])





                    ;
                }
            }
        }

        return profitDP[currentVal.length][savings];
    }

    public static int maximumProfit(int[] presentValues, int[] futureValues, int budget) {
        int numberOfItems = presentValues.length; // Total number of items

        // dp array to store the maximum profit for each budget upto the given budget
        int[] dp = new int[budget + 1];
        int[] profit = new int[presentValues.length];

        for(int i=0; i<presentValues.length; i++){
            profit[i] = futureValues[i] - presentValues[i];
        }

        // Iterate over each item
        for (int i = 0; i < numberOfItems; ++i) {
            int presentValue = presentValues[i];
            int futureValue = futureValues[i];

            // Iterate over all possible remaining budgets in reverse
            // to avoid using same item's profit more than once
            for (int currentBudget = budget; currentBudget >= presentValues[i]; --currentBudget) {
                // Update dp array with the maximum profit achievable with the current budget
                dp[currentBudget] = Math.max(dp[currentBudget], dp[currentBudget - presentValue] + profit[i]);
            }
        }

        // Return the maximum profit that can be achieved with the given budget
        return dp[budget];
    }
}

/*

class Solution {
    public int maximumProfit(int[] presentValues, int[] futureValues, int budget) {
        int numberOfItems = presentValues.length; // Total number of items

        // dp array to store the maximum profit for each budget upto the given budget
        int[] dp = new int[budget + 1];

        // Iterate over each item
        for (int i = 0; i < numberOfItems; ++i) {
            int presentValue = presentValues[i];
            int futureValue = futureValues[i];

            // Iterate over all possible remaining budgets in reverse
            // to avoid using same item's profit more than once
            for (int currentBudget = budget; currentBudget >= presentValue; --currentBudget) {
                // Update dp array with the maximum profit achievable with the current budget
                dp[currentBudget] = Math.max(dp[currentBudget], dp[currentBudget - presentValue] + futureValue - presentValue);
            }
        }

        // Return the maximum profit that can be achieved with the given budget
        return dp[budget];
    }
}
 */
