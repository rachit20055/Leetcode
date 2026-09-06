//Passes on the leetcode 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res=new ArrayList<>();
        int n=s.length();
        int start=0;
        while(start<n)
        {
            Set<Character> set=new HashSet<>();
            for(int end=start;end<n;end++)
            {
                set.add(s.charAt(end));
                boolean valid=true;
                for(int i=0;i<set.size();i++)
                {
                    char c=(char)set.toArray()[i];
                    if(s.lastIndexOf(c)>end){
                        valid=false;
                        break;
                    }
                }
                if(valid){
                    res.add(end-start+1);
                    start=end+1;
                    break;
                }
            }
        }
        return res;
    }
     public static void main(String[] args){
        Solution s=new Solution();
        String str="ababcbacadefegdehijhklij";
        List<Integer> result=s.partitionLabels(str);
        System.out.println(result);
    }
}