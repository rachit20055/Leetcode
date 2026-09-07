class Solution {
    public int distinctSubseqII(String s) {
        int MOD=1000000007;
        long[] dp=new long[s.length()+1];
        long[] arr=new long[26];
        dp[0]=1;
        for(int i=1;i<=s.length();i++)
        {
            int c=s.charAt(i-1)-'a';
            dp[i]=(2*dp[i-1]-arr[c]+MOD)%MOD;
            arr[c]=dp[i-1];
        }
        return (int)(dp[s.length()]-1+MOD)%MOD;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        String str="abc";
        int result=s.distinctSubseqII(str);
        System.out.println(result);
    }
}