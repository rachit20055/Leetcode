
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
     public List<List<String>> solveNQueens(int n){
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)Arrays.fill(board[i],'.');
        boolean[] col=new boolean[n];
        boolean[] posDiag=new boolean[2*n];
        boolean[] negDiag=new boolean[2*n];
        backtrack(0,n,board,res,col,posDiag,negDiag);
        return res;
    }
    public void backtrack(int r,int n,char[][] board,List<List<String>> res,boolean[] col,boolean[] posDiag,boolean[] negDiag){
        if(r==n){
            List<String> list=new ArrayList<>();
            for(char[] row:board)list.add(new String(row));
            res.add(list);
            return;
        }
        for(int c=0;c<n;c++){
            if(col[c]||posDiag[r+c]||negDiag[r-c+n])continue;
            col[c]=true;
            posDiag[r+c]=true;
            negDiag[r-c+n]=true;
            board[r][c]='Q';
            backtrack(r+1,n,board,res,col,posDiag,negDiag);
            col[c]=false;
            posDiag[r+c]=false;
            negDiag[r-c+n]=false;
            board[r][c]='.';
        }
    }
    public static void main(String[] args){
        Solution obj=new Solution();
        int n=12;
        List<List<String>> res=obj.solveNQueens(n);
        for(List<String> board:res){
            for(String row:board){
                System.out.println(row);
            }
            System.out.println();
        }
    }
}