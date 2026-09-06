class Solution {
    public int numDistinct(String s,String t) {
        int m=s.length();
        int n=t.length();
        Integer[][] memo=new Integer[m][n];
        return solve(s,t,m-1,n-1,memo);
    }
    public int solve(String s,String t,int i,int j,Integer[][] memo){
        if(j<0)
        {
            return 1;
        }
        if(i<0)
        {
            return 0;
        }
        if(j>i)
        {
            return 0;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            return memo[i][j]=solve(s,t,i-1,j-1,memo)+solve(s,t,i-1,j,memo);
        }
        return memo[i][j]=solve(s,t,i-1,j,memo);
    }
    public static void main (String[] args) throws java.lang.Exception
	{
		Solution c=new Solution();
		int n=c.numDistinct("babgbag","bag");
        System.out.println(n);
	}
}