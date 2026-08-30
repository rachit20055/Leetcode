import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> part=new ArrayList<>();
        dfs(0,s.length(),res,part,s);
        return res;
    }
    public void dfs(int i,int n, List<List<String>> res,List<String> part,String s)
    {
        if(i>=n)
        {
            res.add(new ArrayList<>(part));
            return;
        }
        for(int j=i;j<n;j++)
        {
            if(isPalindrome(s,i,j))
            {
                part.add(s.substring(i,j+1));
                dfs(j+1,n,res,part,s);
                part.remove(part.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        Solution obj=new Solution();
        String s="aabaalkaabaaabasabbabaaaabababab";
        List<List<String>> res=obj.partition(s);
        System.out.println(res);
    }
}