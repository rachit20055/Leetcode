import java.util.Arrays;
class Solution {
    public int[] minInterval(int[][] intervals,int[] queries) {
        int n=intervals.length;
        int res[]=new int[queries.length];
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<queries.length;i++){
            int minIndex=-1;
            int prev=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(intervals[j][0]<=queries[i]&&queries[i]<=intervals[j][1]){
                    int len=intervals[j][1]-intervals[j][0]+1;
                    if(len<prev){
                        minIndex=j;
                        prev=len;
                    }
                }
            }
            res[i]=minIndex==-1?-1:prev;
        }
        return res;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[][] intervals={{1,4},{2,4},{3,6},{4,4}};
        int[] queries={2,3,4,5};
        int[] result=s.minInterval(intervals,queries);
        System.out.println(Arrays.toString(result));
    }
}