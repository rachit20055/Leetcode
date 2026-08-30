
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums,res,new ArrayList<>(),0,nums.length);
        return res;
    }
    public void subsets(int[] nums,List<List<Integer>> res,List<Integer> a,int i, int n)
    {
        if(i==n)
        {
            res.add(new ArrayList<>(a));
        }
        else
        {
            a.add(nums[i]);
            subsets(nums,res,a,i+1,n);
            a.remove(a.size()-1);
            while(i+1<nums.length&&nums[i]==nums[i+1])
            {
                i++;
            }
            subsets(nums,res,a,i+1,n);
        }
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums={1,2,2};
        List<List<Integer>> result=s.subsetsWithDup(nums);
        System.out.println(result);
    }
}