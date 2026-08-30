import java.util.ArrayList;
import java.util.List;
class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        subsets(nums,res,new ArrayList<>(),0,nums.length);
        return res;
    }
    public void subsets(int[] nums, List<List<Integer>> res,List<Integer> a,int i, int n)
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
            subsets(nums,res,a,i+1,n);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution78 sol = new Solution78();
        List<List<Integer>> result = sol.subsets(nums);
        System.out.println(result);
    }
}