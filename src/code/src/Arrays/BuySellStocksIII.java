package src.Arrays;


class BuySellStocksIII {
    public int maxProfit(int[] prices) {
        int profit1 = 0;
        int profit2 = 0;
        int profit = 0;
        int lsp = 0;
        int lbp = 0;

        for(int i=0; i< prices.length-1; i++)
        {

            if(prices[i+1] > prices[i])
            {
                if(i+1 == lsp +1)
                {
                    profit = profit + prices[i+1] - prices[lsp];
                    lsp = i+1;
                    if(i+1 < prices.length -1)continue;
                }
                else
                {
                    profit = prices[i+1] - prices[i];
                    lsp = prices[i+1];
                    lbp = prices[i];


                }

                if(profit > profit1)
                {
                    profit1 = profit;
                }
                else if(profit > profit2)
                {
                    profit2 = profit;
                }
            }


        }

        System.out.println(profit1);
        System.out.println(profit2);

        System.out.println(profit1 + profit2);
        return profit1 + profit2;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,3,7,9,0,5};
        BuySellStocksIII bs = new BuySellStocksIII();
        bs.maxProfit(prices);
    }

}

