
import java.util.Arrays;

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount + 1];
        for (int i=0;i<coins.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0,coins,amount,dp);
    }
    public int solve(int i, int[] coins,int amount,int[][] dp)
    {
        if(amount==0)
        {
            return 1;
        }
        if(amount<0||i>=coins.length)
        {
            return 0;
        }
        if(dp[i][amount]!=-1)
        {
            return dp[i][amount];
        }
        int take=solve(i,coins,amount-coins[i],dp);
        int skip=solve(i+1,coins,amount,dp);
        return dp[i][amount]=take+skip;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int amount=5;
        int[] coins={1,2,5};
        int result=s.change(amount,coins);
        System.out.println(result);
    }
}