class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int end=0;
        int farthest=0;
        for(int i=0;i<nums.length-1;i++)
        {
            farthest=Math.max(farthest,i+nums[i]);
            if(i==end)
            {
                jumps++;
                end=farthest;
            }
        }
        return jumps;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums={2,3,0,1,4};
        int result=s.jump(nums);
        System.out.println(result);
    }
}