import java.util.Arrays;
class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int max=0;
        dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                max=Math.max(dfs(matrix,i,j,-1),max);
            }
        }
        return max;
    }
    public int dfs(int[][] grid,int i, int j,int prev)
    {
         if(i>=grid.length||i<0||j>=grid[0].length||j<0||grid[i][j]==-1||grid[i][j]<=prev)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int temp=grid[i][j];
        grid[i][j]=-1;
        dp[i][j]=1+Math.max(Math.max(dfs(grid,i+1,j,temp),dfs(grid,i-1,j,temp)),Math.max(dfs(grid,i,j+1,temp),dfs(grid,i,j-1,temp)));
        grid[i][j]=temp;   
        return dp[i][j];
    }
     public static void main(String[] args) {
        Solution s=new Solution();
        int[][] matrix={
            {9,10,12},
            {6,2,14},
            {3,2,15}
        };
        int result=s.longestIncreasingPath(matrix);
        System.out.println(result);
    }
}