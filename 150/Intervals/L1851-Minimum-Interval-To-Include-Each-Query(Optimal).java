import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {
    public int[] minInterval(int[][] intervals,int[] queries) {
        int n=intervals.length;
        int q=queries.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[][] qs=new int[q][2];
        for(int i=0;i<q;i++){
            qs[i]=new int[]{queries[i],i};
        }
        Arrays.sort(qs,(a,b)->a[0]-b[0]);
        int[] res=new int[q];
        Arrays.fill(res,-1);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int j=0;
        for(int[] x:qs){
            int val=x[0];
            int idx=x[1];
            while(j<n&&intervals[j][0]<=val){
                int start=intervals[j][0];
                int end=intervals[j][1];
                pq.offer(new int[]{end-start+1,end});
                j++;
            }
            while(!pq.isEmpty()&&pq.peek()[1]<val){
                pq.poll();
            }
            if(!pq.isEmpty()){
                res[idx]=pq.peek()[0];
            }
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