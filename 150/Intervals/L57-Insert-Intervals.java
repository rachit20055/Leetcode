import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[][] insert(int[][] intervals,int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]<newInterval[0]){
                list.add(intervals[i]);
            }
            else if(intervals[i][0]>newInterval[1]){
                list.add(newInterval);
                for(int j=i;j<intervals.length;j++){
                    list.add(intervals[j]);
                }
                return list.toArray(int[][]::new);
            }
            else{
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            }
        }
        list.add(newInterval);
        return list.toArray(int[][]::new);
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[][] intervals={
            {1,3},
            {6,9}
        };
        int[] newInterval={2,5};
        int[][] result=s.insert(intervals,newInterval);
        for(int[] interval:result){
            System.out.println(Arrays.toString(interval));
        }
    }
}