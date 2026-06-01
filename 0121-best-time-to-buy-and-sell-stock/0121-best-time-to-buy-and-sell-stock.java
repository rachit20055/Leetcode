class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int highest=prices[n-1];
        int i=n-2;
        int diff=0,max=0;
        while(i>=0)
        {
            diff=highest-prices[i];
            max=Math.max(max,diff);
            if(highest<prices[i])
            {
                highest=prices[i];
            }
          
            i--;
        }
        return max;
    }
}