import java.util.Arrays;
class Solution {
    public void rotate(int[][] matrix) {
        int left=0;
        int right=matrix.length-1;
        while(left<right)
        {
            for(int i=0;i<right-left;i++)
            {
                int top=left;
                int bottom=right;
                int topL=matrix[top][left+i];
                matrix[top][left+i]=matrix[bottom-i][left];
                matrix[bottom-i][left]=matrix[bottom][right-i];
                matrix[bottom][right-i]=matrix[top+i][right];
                matrix[top+i][right]=topL;
            }
                right--;
                left++;
        }
    }
    public static void main(String[] args){
        Solution obj=new Solution();
        int[][] matrix={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        obj.rotate(matrix);
        for(int[] row:matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}