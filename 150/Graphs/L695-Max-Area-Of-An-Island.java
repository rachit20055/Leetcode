class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int area=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                area=Math.max(area,dfs(grid,i,j));
            }
        }
        return area;
    }
    private int dfs(int[][] grid,int r,int c){
        int rows = grid.length;
        int cols=grid[0].length;
        if(r<0||c<0||r>=rows||c>=cols||grid[r][c]==0)
        {
            return 0;
        }
        grid[r][c]=0;
        return (1+dfs(grid, r-1,c)+dfs(grid,r+1,c)+dfs(grid,r,c-1)+dfs(grid,r,c+1));
    }
    public static void main(String[] args)
    {
        int[][] grid={
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        Solution s=new Solution();
        System.out.println(s.maxAreaOfIsland(grid));
    }
}