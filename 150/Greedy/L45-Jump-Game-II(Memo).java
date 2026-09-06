import java.util.Arrays;
class Solution {
    int dp[];
    public int jump(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return traverse(0,nums);
    }
    public int traverse(int i,int[] nums){
        if(i==nums.length-1) return 0;
        if(dp[i]!=-1) 
        {
            return dp[i];
        }
        dp[i]=Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];j++){
            if(i+j<nums.length){
                int next=traverse(i+j,nums);
                if(next!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+next);
                }
            }
        }
        return dp[i];
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums={2,3,0,1,4};
        int result=s.jump(nums);
        System.out.println(result);
    }
    
}