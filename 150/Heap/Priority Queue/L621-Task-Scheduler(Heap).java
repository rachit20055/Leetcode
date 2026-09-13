
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char task: tasks)
        {
            freq[task-'A']++;
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int f:freq)
        {
            if(f>0)
            {
                maxHeap.add(f);
            }
        }
        Queue<int[]> count=new LinkedList<>();
        int t=0;
        while(!maxHeap.isEmpty()||!count.isEmpty())
        {
            if(!count.isEmpty()&&count.peek()[1]==t)
            {
                maxHeap.add(count.poll()[0]);
            }
            if(!maxHeap.isEmpty())
            {
                int task=maxHeap.poll();
                task--;
                if(task>0)
                {
                    count.add(new int[]{task,t+n+1});
                }
            }
            t++;
        }
        return t;
    }
     public static void main(String[] args) {
        Solution s=new Solution();
        char[] tasks={'A','A','A','B','B','B'};
        int n=2;
        int result=s.leastInterval(tasks,n);
        System.out.println(result);
    }
}