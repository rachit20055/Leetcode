import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> a=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-2;i++)
        {
            if(i>0&&nums[i]==nums[i-1])
            {
                continue;
            }
            int left=i+1;
            int right=n-1;
            while(left<right)
            {
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0)
                {
                    a.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left+1])
                    {
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1])
                    {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum<0)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return a;
    }
     public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution sol = new Solution();
        List<List<Integer>> result = sol.threeSum(nums);
        System.out.println(result);
    }
}