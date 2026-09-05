class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int min[]=new int[n];
        min[n-1]=nums[n-1];                               
        for(int i=n-2;i>=0;i--)
        {
            min[i]=Math.min(nums[i],min[i+1]);
        }
        int max=nums[0];
        for(int i=0;i<n;i++)
        {
            max=Math.max(nums[i],max);
            if(k>=(max-min[i]))
            {
                return i;
            }
        }
        return -1;
    }
    public static void main (String[] args) throws java.lang.Exception
	{
	     Solution c=new Solution();
	     int n=c.firstStableIndex(new int[]{5,0,1,4},3);
         System.out.println(n);
	}
}