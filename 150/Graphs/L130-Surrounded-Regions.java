
import java.util.Arrays;

class Solution {
    public void solve(char[][] board) {
        if(board==null||board.length==0)
        {
            return;
        }
        int rows=board.length;
        int cols=board[0].length;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]=='O'&&(r==0||r==rows-1||c==0||c==cols-1)){
                    capture(board,r,c,rows,cols);
                }
            }
        }
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }
            }
        }
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]=='T'){
                    board[r][c]='O';
                }
            }
        }
    }
    private void capture(char[][] board,int r,int c,int rows,int cols){
        if(r<0||c<0||r==rows||c==cols||board[r][c]!='O')
        {
            return;
        }
        board[r][c]='T';
        capture(board,r+1,c,rows,cols);
        capture(board,r-1,c,rows,cols);
        capture(board,r,c+1,rows,cols);
        capture(board,r,c-1,rows,cols);
    }
    public static void main(String[] args) {
        Solution solver=new Solution();
        char[][] board={
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        solver.solve(board);
        for(char[] row:board){
            System.out.println(Arrays.toString(row));
        }
    }
}