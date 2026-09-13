import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int n: stones)
        {
            maxHeap.add(n);
        }
        while(maxHeap.size()>1)
        {
            int y=maxHeap.remove();
            int x=maxHeap.remove();
            if(x!=y)
            {
                maxHeap.add(y-x);
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] stones={2,7,4,1,8,1};
        int result=s.lastStoneWeight(stones);
        System.out.println(result);
    }
}