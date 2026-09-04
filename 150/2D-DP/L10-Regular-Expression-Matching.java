class Solution {
    public boolean isMatch(String s, String p) {
        Boolean memo[][]=new Boolean[s.length()+1][p.length()+1];
        return dfs(0,0,s,p,memo);
    }
    public boolean dfs(int i,int j,String s, String p,Boolean memo[][])
    {
        if(i>=s.length()&&j>=p.length())
        {
            return true;
        }
        if(j>=p.length())
        {
            return false;
        }
         if(memo[i][j]!=null)
        {
            return memo[i][j];
        }
        boolean match=i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.');
        if(j+1<p.length()&&p.charAt(j+1)=='*')
        {
            memo[i][j]= dfs(i,j+2,s,p,memo)||(match&&dfs(i+1,j,s,p,memo));
            return memo[i][j];
        }
        else if(match)
        {
            memo[i][j]=dfs(i+1,j+1,s,p,memo);
            return memo[i][j];
        }
        else
        {
            return memo[i][j]!=null?memo[i][j]:false;
        }
    }
    public static void main(String[] args)
    {
        Solution s=new Solution();
        System.out.println(s.isMatch("a*","aaaab")?"true":"false");
    }
}