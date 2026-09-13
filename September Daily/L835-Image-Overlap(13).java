
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        List<int[]> a=new ArrayList<>();
        List<int[]> b=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(img1[i][j]==1)
                {
                    a.add(new int[]{i,j});
                }
                if(img2[i][j]==1)
                {
                    b.add(new int[]{i,j});
                }
            }
        }
        HashMap<String,Integer> map=new HashMap<>();
        int res=0;
        for(int[] x:a)
        {
            for(int[] y:b)
            {
                int dx=y[0]-x[0];
                int dy=y[1]-x[1];
                String key=dx+","+dy;
                map.put(key,map.getOrDefault(key,0)+1);
                res=Math.max(res,map.get(key));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[][] img1={
            {1,1,0},
            {0,1,0},
            {0,1,0}
        };
        int[][] img2={
            {0,0,0},
            {0,1,1},
            {0,0,1}
        };
        int result=s.largestOverlap(img1,img2);
        System.out.println(result);
    }
}