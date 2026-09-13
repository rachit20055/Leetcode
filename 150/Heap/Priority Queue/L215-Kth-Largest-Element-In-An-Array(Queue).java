import java.util.PriorityQueue;
class Solution {
    PriorityQueue<Integer> minHeap;
    public int findKthLargest(int[] nums, int k) {
        minHeap=new PriorityQueue<>();
        for(int i=0;i<k;i++)
        {
            minHeap.offer(nums[i]);
        }
        for(int i=k;i<nums.length;i++)
        {
            if(minHeap.peek()<nums[i])
            {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums={3,2,1,5,6,4};
        int k=2;
        int result=s.findKthLargest(nums,k);
        System.out.println(result);
    }
}