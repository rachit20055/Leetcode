
import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer>minHeap;
    PriorityQueue<Integer>maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    }
    public void addNum(int num) {
        maxHeap.add(num);
        if(!maxHeap.isEmpty()&&!minHeap.isEmpty()&&maxHeap.peek()>minHeap.peek())
        {
            int val=maxHeap.poll();
            minHeap.add(val);
        }
        if(maxHeap.size()>minHeap.size()+1){
            int val=maxHeap.poll();
            minHeap.add(val);
        }
        if(minHeap.size()>maxHeap.size()+1){
            int val=minHeap.poll();
            maxHeap.add(val);
        }
    }
    public double findMedian() {
       if(maxHeap.size()>minHeap.size())
       {
           return maxHeap.peek();
       }
       if(minHeap.size()>maxHeap.size())
       {
           return minHeap.peek();
       }
          
           return ((double)minHeap.peek()+(double)maxHeap.peek())/2;
    }
    public static void main(String[] args) {
        MedianFinder mf=new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}