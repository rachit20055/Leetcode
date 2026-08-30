class Solution {
     public boolean exist(char[][] board, String word) {
        for(int r=0;r<board.length;r++) {
            for(int c=0;c<board[0].length;c++) {
                if(check(board,r,c,0,word)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean check(char[][] board, int i, int j, int k, String word) {
        if(k==word.length()) {
            return true;  
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length) {
            return false;
        }
        if(board[i][j]!=word.charAt(k)) {
            return false;
        }
        char temp=board[i][j];
        board[i][j]='#';
        boolean found=check(board,i+1,j,k+1,word)||check(board,i,j+1,k+1,word)||check(board,i-1,j,k+1,word)||check(board,i,j-1,k+1,word);
        board[i][j]=temp; 
        return found;
    }
    public static void main(String[] args)
    {
        Solution s=new Solution();
        char[][] mat={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean bol=s.exist(mat,"SEE");
        System.out.println(bol);
    }
}