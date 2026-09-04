
import java.util.Arrays;

class Solution{
    public int findTargetSumWays(int[] nums,int target){
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(Math.abs(target)>sum){
            return 0;
        }
        int[][] dp=new int[nums.length][2*sum+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return check(0,0,nums,dp,target,sum);
    }
    public int check(int i,int amount,int[] nums,int[][] dp,int target,int sum){
        if(i==nums.length){
            return amount==target?1:0;
        }
        if(dp[i][amount+sum]!=-1){
            return dp[i][amount+sum];
        }
        int add=check(i+1,amount+nums[i],nums,dp,target,sum);
        int sub=check(i+1,amount-nums[i],nums,dp,target,sum);
        return dp[i][amount+sum]=add+sub;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums={1,1,1,1,1};
        int target=3;
        int result=s.findTargetSumWays(nums,target);
        System.out.println(result);
    }
}