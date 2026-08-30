import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        permutation(res,nums,0);
        return res;
    }
    public void permutation(List<List<Integer>> res,int[] nums, int index)
    {
        if(index==nums.length)
        {
            List<Integer> list = Arrays.stream(nums)
                           .boxed()
                           .toList();
            res.add(list);
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            swap(nums,i,index);
            permutation(res,nums,index+1);
            swap(nums,i,index);
        }
    }
    public void swap(int arr[],int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution sol = new Solution();
        List<List<Integer>> result = sol.permute(nums);
        System.out.println(result);
    }
}