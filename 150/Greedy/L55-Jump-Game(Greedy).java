class Solution {
    public boolean canJump(int[] nums) {
        int farthest=0;
        for(int i=0;i<nums.length;i++) {
            if(i>farthest)
                return false;
            farthest=Math.max(farthest,i+nums[i]);
            if(farthest>=nums.length-1)
                return true;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.canJump(new int[]{3,2,1,0,5})?"True":"False");
    }
}