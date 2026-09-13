import java.util.PriorityQueue;
class KthLargest {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int n:nums)
        {
            minHeap.add(n);
        }
        while(minHeap.size()>k)
        {
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>k)
        {
            minHeap.poll();
        }
        return minHeap.peek();    
    }
    public static void main(String[] args) {
        int k=3;
        int[] nums={4,5,8,2};
        KthLargest obj=new KthLargest(k,nums);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */