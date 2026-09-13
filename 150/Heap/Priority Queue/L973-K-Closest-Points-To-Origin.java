
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->distance(b)-distance(a));
        for(int[] n:points)
        {
            maxHeap.add(n);
             if(maxHeap.size()>k) 
             {
                maxHeap.poll();
             }
        }
        int[][] res=new int[k][2];
        for(int i=0;i<k;i++)
        {
            res[i]=maxHeap.poll();
        }
        return res;
    }
    public int distance(int[] points)
    {
        return points[0]*points[0]+points[1]*points[1];
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[][] points={{3,3},{5,-1},{-2,4}};
        int k=2;
        int[][] result=s.kClosest(points,k);
        for(int[] point:result){
            System.out.println(Arrays.toString(point));
        }
    }
}