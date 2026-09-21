import java.util.Arrays;
class Solution {
    public long[] resultArray(int[] nums,int k) {
        long[] res=new long[k];
        long[] dp=new long[k];
        for(int num:nums) 
        {
            long[] next=new long[k];
            next[num%k]++;
            for(int r=0;r<k;r++) 
            {
                if(dp[r]>0) 
                {
                    int rem=(int)(((long)r*num)%k);
                    next[rem]+=dp[r];
                }
            }
            for(int r=0;r<k;r++)
            {
                res[r]+=next[r];
            }
            dp=next;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums={2,3,4};
        int k=5;
        long[] result=s.resultArray(nums,k);
        System.out.println(Arrays.toString(result));
    }
}