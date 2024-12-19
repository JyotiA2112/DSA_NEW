package code.interviews.googlePrep;


class KnapSack {

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                            = Math.max(val[i - 1]
                                    + K[i - 1][w - wt[i - 1]],
                            K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    public static int maximumProfit(int[] presentValues, int[] profit, int budget) {
        int numberOfItems = presentValues.length; // Total number of items

        // dp array to store the maximum profit for each budget upto the given budget
        int[] dp = new int[budget + 1];


        // Iterate over each item
        for (int i = 0; i < numberOfItems; ++i) {
            int presentValue = presentValues[i];

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

    // Driver code
    public static void main(String args[])
    {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };





        int W = 50;
        int n = profit.length;
        //System.out.println(knapSack(W, weight, profit, n));
        System.out.println(maximumProfit(weight, profit, W));
    }
}
/*This code is contributed by Rajat Mishra */

