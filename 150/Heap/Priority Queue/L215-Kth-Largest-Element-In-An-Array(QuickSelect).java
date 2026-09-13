import java.util.Random;
class Solution {
    Random rand=new Random();
    public int findKthLargest(int[] nums,int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }
    public int quickSelect(int[] nums,int l,int r,int k) {
        int pivot=nums[l+rand.nextInt(r-l+1)];
        int low=l;
        int high=r;
        int i=l;
        while(i<=high){
            if(nums[i]<pivot){
                swap(nums,i,low);
                i++;
                low++;
            }
            else if(nums[i]>pivot){
                swap(nums,i,high);
                high--;
            }
            else{
                i++;
            }
        }
        if(k<low)
            return quickSelect(nums,l,low-1,k);
        if(k>high)
            return quickSelect(nums,high+1,r,k);
        return nums[k];
    }
    public void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums={3,2,1,5,6,4};
        int k=2;
        int result=s.findKthLargest(nums,k);
        System.out.println(result);
    }
}