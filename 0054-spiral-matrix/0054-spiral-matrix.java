class Solution {
    public List<Integer> spiralOrder(int[][] a) {

        int m=a.length;
        int n=a[0].length;
        int rowstart=0;
        int rowend=m-1;
        int colstart=0;
        int colend=n-1;
        List<Integer> b= new ArrayList<>();
        int j=0;
        while(j!=(m*n)){
        if(j==(m*n))
        {
            return b;
        }
        for(int i=colstart;i<=colend;i++)
            {
                b.add(a[rowstart][i]);
                j++;
            }
        if(j==(m*n))
        {
            return b;
        }
        rowstart=rowstart+1;
        for(int i=rowstart;i<=rowend;i++)
            {
                b.add(a[i][colend]);
                j++;
            }
        if(j==(m*n))
        {
            return b;
        };
        colend=colend-1;
        for(int i=colend;i>=colstart;i--)
            {
                b.add(a[rowend][i]);
                j++;
            }
        rowend=rowend-1;
        for(int i=rowend;i>=rowstart;i--)
            {
                b.add(a[i][colstart]);
                j++;
            }
        if(j==(m*n))
        {
            return b;
        }
        colstart=colstart+1;
        }
        return b;
        
    }
}