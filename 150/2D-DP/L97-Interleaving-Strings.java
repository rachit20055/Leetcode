import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    Map<List<Integer>,Boolean> memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
        {
            return false;
        }
        memo=new HashMap<>();
        return dfs(0,0,s1,s2,s3);
    }
    public boolean dfs(int i,int j,String s1, String s2, String s3)
    {
        if(i>=s1.length()&&j>=s2.length())
        {
            return true;
        }
        List<Integer> key=List.of(i,j);
        if(memo.containsKey(key))
        {
            return memo.get(key);
        }
        int index=i+j;
        boolean result=false;
        if(i<s1.length()&&s1.charAt(i)==s3.charAt(index))
        {
            result=dfs(i+1,j,s1,s2,s3);
        }
        if(!result&&j<s2.length()&&s2.charAt(j)==s3.charAt(index))
        {
            result=dfs(i,j+1,s1,s2,s3);
        }
        memo.put(key,result);
        return result;
    }
    public static void main(String[] args) {
        Solution sol=new Solution();
        String s1="aabcc";
        String s2="dbbca";
        String s3="aadbbcbcac";
        boolean result=sol.isInterleave(s1,s2,s3);
        System.out.println("Is Interleaving: "+result);
    }
}