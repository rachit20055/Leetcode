class Solution {
    Boolean dp[];
    public boolean canJump(int[] nums) {
        dp=new Boolean[nums.length];
        return traverse(0,nums);
    }
    public boolean traverse(int i, int[] nums)
    {
        if(i==nums.length-1)
        {
            return true;
        }
        if(dp[i]!=null)
        {
            return dp[i];
        }
        dp[i]=false;
        for(int j=1;j<=nums[i];j++)
        {
            dp[i]=dp[i]||traverse(i+j,nums);
        }
        return dp[i];
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.canJump(new int[]{3,2,1,0,5})?"True":"False");
    }
}