class isValid{
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                     if(!(isValid(board[i][j],i,j,board)))
                     {
                         return false;
                     }
                }
            }
        }
        return true;
    }
    public boolean isValid(char num,int row,int column, char[][] b)
    {
        for(int i=0;i<9;i++)
        {
            if(b[row][i]==num)
            {
                if(column==i)
                {
                    continue;
                }
                return false;
            }
            if(b[i][column]==num)
            {
                if(row==i)
                {
                    continue;
                }
                return false;
            }
        }
        int brstart=(int)Math.floor(row/3)*3;
        int bcstart=(int)Math.floor(column/3)*3;
        for(int i=brstart;i<brstart+3;i++)
        {
            for(int j=bcstart;j<bcstart+3;j++)
            {
                if(i==row&&column==j)
                {
                    continue;
                }
                if(b[i][j]==num)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        isValid obj = new isValid();
        System.out.println(obj.isValidSudoku(board));

    }
}
