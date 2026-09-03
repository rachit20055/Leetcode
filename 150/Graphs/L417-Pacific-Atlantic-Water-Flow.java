import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            dfs(heights,0,i,pacific,heights[0][i]);
            dfs(heights,m-1,i,atlantic,heights[m-1][i]);
        }
        for(int i=0;i<m;i++)
        {
            dfs(heights,i,0,pacific,heights[i][0]);
            dfs(heights,i,n-1,atlantic,heights[i][n-1]);
        }   
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(pacific[i][j]&&atlantic[i][j])
                {
                   res.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return res;
    }
    public void dfs(int[][] heights, int r, int c, boolean[][] visited,int prevHeight)
    {
        if(r<0||c<0||r==heights.length||c==heights[0].length||heights[r][c]<prevHeight||visited[r][c]==true)
        {
            return;
        }
        visited[r][c]=true;
        dfs(heights,r+1,c,visited,heights[r][c]);
        dfs(heights,r,c-1,visited,heights[r][c]);
        dfs(heights,r-1,c,visited,heights[r][c]);
        dfs(heights,r,c+1,visited,heights[r][c]);
    }
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        System.out.println("Input Heights Matrix:");
        for (int[] row : heights) {
            System.out.println(Arrays.toString(row));
        }
        List<List<Integer>> result = solver.pacificAtlantic(heights);
        System.out.println("\nCoordinates that can flow to both Pacific and Atlantic:");
        System.out.println(result);
    }
}