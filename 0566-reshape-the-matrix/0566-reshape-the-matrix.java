class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int a[][]=new int[r][c];
        int m=mat.length;
        int n=mat[0].length;
        int k=0,l=0;
        if(m*n!=r*c)
        {
            return mat;
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[k][l]=mat[i][j];
                l++;
                if(l==c)
                {
                    l=0;
                    k++;
                }
            }
        }
        return a;
    }
}