class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int sum=nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum=Math.max(nums[i], sum+nums[i]);
            max=Math.max(max, sum);
        }

        return max;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.maxSubArray(new int[]{4,5,6,7,9,-1,-15,23,68,-96}));
    }
}