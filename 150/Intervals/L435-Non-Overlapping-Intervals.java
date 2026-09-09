import java.util.Arrays;
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0)
        {
            return 0;
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int remove=0;
        int prev=intervals[0][1];
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<prev)
            {
                remove++;
            }
            else
            {
                prev=intervals[i][1];
            }
        }
        return remove;
    }
    public static void main(String[] args) {
        int a[][]={{1,3},{2,6},{8,10},{15,18}};
        Solution s=new Solution();
        System.out.println(s.eraseOverlapIntervals(a));
    }
}