class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> a=new HashSet<>();
    int n=nums.length;
    for(int i=0;i<n;i++)
    {
        if(a.contains(nums[i]))
        {
            return true;
        }
        else{
        a.add(nums[i]);
        }
    }
    return false;
    }
}