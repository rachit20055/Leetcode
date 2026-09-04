class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int[] dp1 : dp) {
            for (int j = 0; j < dp1.length; j++) {
                dp1[j] = 0;
            }
        }
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--)
            {
                if(text1.charAt(i)==text2.charAt(j))
                {
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int n=s.longestCommonSubsequence("logistics","acer");
        System.out.println(n);
    }
}