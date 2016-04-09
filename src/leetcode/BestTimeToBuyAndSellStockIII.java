package leetcode;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length<1)
        {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        int n = prices.length;
        int[] result1 = new int[n];
        for(int i=1;i<n;i++)
        {
            if(prices[i]<min)
            {
                min = prices[i];
                result1[i] = max;
            }
            else
            {
                max = Math.max(prices[i]-min, max);
                result1[i] = max;
            }
        }
        max = 0;
        int maximum = prices[n-1];
        int[] result2 = new int[n];
        for(int i = n-2;i>=0;i--)
        {
            if(prices[i]>maximum)
            {
                maximum = prices[i];
                result2[i] = max;
            }
            else
            {
                max = Math.max(maximum-prices[i], max);
                result2[i] = max;
            }
        }
        max = 0;
        for(int i=0;i<n;i++)
        {
            int m = result1[i] + result2[i];
            if(m>max)
            {
                max = m;
            }
        }
        return max;
    }
}
