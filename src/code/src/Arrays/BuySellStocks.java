package src.Arrays;

public class BuySellStocks {

    public static void main(String[] args) {
        BuySellStocks bs = new BuySellStocks();
        int[] arr = new int[]{7,1,5,3,6,4};
        bs.maxProfit(arr);
    }

    public int maxProfit(int[] prices) {

        int buy = 0;
        int sell = 0;
        int profit = 0;


        for (int i=0; i<prices.length - 1; i++)
        {



            if(prices[i+1]>prices[i] && profit<(prices[i+1]-prices[buy]))
            {
                sell = i+1;
            }
            else if(prices[buy]>prices[i+1] && profit<(prices[sell]-prices[i+1])){
                buy = i+1;
                sell = buy;
            }


            profit = prices[sell] - prices[buy];
        }

        return profit;

    }
}
