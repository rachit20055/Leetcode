class Solution {
    public boolean uniformArray(int[] nums1) {
        int max=Integer.MAX_VALUE;
        for(int x:nums1)
        {
            if(x%2==1)
            {
                max=Math.min(max,x);
            }
        }
        for(int x:nums1)
        {
            if(x%2==0&&max!=Integer.MAX_VALUE&&x<max)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] test1={4, 3, 7, 8};
        System.out.println("Test 1 Result:"+solution.uniformArray(test1));
        int[] test2={2, 5, 9, 6};
        System.out.println("Test 2 Result:"+solution.uniformArray(test2));
        int[] test3={2, 4, 6, 8};
        System.out.println("Test 3 Result:"+solution.uniformArray(test3)); 
        int[] test4={3, 5, 7, 9};
        System.out.println("Test 4 Result:"+solution.uniformArray(test4)); 
    }
}