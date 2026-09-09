import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> result=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        for (int i=1;i<intervals.length;i++) {
            int nextStart=intervals[i][0];
            int nextEnd=intervals[i][1];
            if (nextStart<=end) {
                end = Math.max(end, nextEnd);
            } 
            else {
                result.add(new int[]{start, end});
                start = nextStart;
                end = nextEnd;
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(int[][]::new);
    }
    public static void main(String[] args)
    {
      Solution s=new Solution();
      int a[][]={{1,3},{2,6},{8,10},{15,18}};
      int[][] merged=s.merge(a);
      for(int[] b: merged)
      {
        for(int n: b)
        {
          System.out.print(n+",");
        }
        System.out.println();
      }
    }
}