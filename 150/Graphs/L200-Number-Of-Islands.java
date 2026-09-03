
import java.util.LinkedList;
import java.util.Queue;

class Solution{
    public int numIslands(char[][] grid){
        if(grid.length==0)return 0;

        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visit=new boolean[rows][cols];
        int islands=0;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]=='1'&&!visit[r][c]){
                    bfs(r,c,grid,visit);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void bfs(int r,int c,char[][] grid,boolean[][] visit){
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{r,c});
        visit[r][c]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];

            for(int[] dir:directions){
                int nr=row+dir[0];
                int nc=col+dir[1];

                if(nr>=0&&nr<rows&&nc>=0&&nc<cols&&grid[nr][nc]=='1'&&!visit[nr][nc]){
                    q.offer(new int[]{nr,nc});
                    visit[nr][nc]=true;
                }
            }
        }
    }
    public class Main{
    public static void main(String[] args){
        Solution obj=new Solution();

        char[][] grid={
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        System.out.println(obj.numIslands(grid));
    }
}
}