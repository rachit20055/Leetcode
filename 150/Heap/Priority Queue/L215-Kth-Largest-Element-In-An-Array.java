// QuickSelect solution
class Solution {
    public int findKthLargest(int[] nums, int k) {  
        int target=nums.length-k;
        return findKth(nums,0,nums.length-1,target);     
    }
    public int findKth(int[] arr,int low, int high, int k)
    {
        int partition=partition(arr,low,high);
        if(partition==k)
             return arr[partition];
        else if(partition<k)
             return findKth(arr,partition+1,high,k);
        else
             return findKth(arr,low,partition-1,k);
    }
    public int partition(int arr[],int low,int high)
    {
        int pivot=arr[high];
        int pivotloc=low;
        for(int i=low;i<=high;i++)
        {
            if(arr[i]<pivot)
            {
                int temp=arr[i];
                arr[i]=arr[pivotloc];
                arr[pivotloc]=temp;
                pivotloc++;
            }
        }
        int temp=arr[high];
        arr[high]=arr[pivotloc];
        arr[pivotloc]=temp;
        return pivotloc;
    }
     public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums={3,2,1,5,6,4};
        int k=2;
        int result=s.findKthLargest(nums,k);
        System.out.println(result);
    }
}