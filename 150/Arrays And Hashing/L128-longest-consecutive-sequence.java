import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        SortedSet<Integer> hash=new TreeSet<>();
        for(int n:nums)
        {
            hash.add(n);
        }
        int i=1;
        int max=0;
        List<Integer> list=new ArrayList<>(hash);
        for(int k=0;k<list.size()-1;k++)
        {
           if(list.get(k+1)==list.get(k)+1)
           {
            i++;
           }
           else
           {
               i=1;
           }
           max=Math.max(max,i);

        }
        return max;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int nums[]={0,3,7,2,5,8,4,6,0,1};
        System.out.println(s.longestConsecutive(nums));
    }
}