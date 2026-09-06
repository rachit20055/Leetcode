import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res=new ArrayList<>();
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-'a']=i;
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++)
        {
            end=Math.max(end,arr[s.charAt(i)-'a']);
            if(i==end){
                res.add(end-start+1);
                start=i+1;
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