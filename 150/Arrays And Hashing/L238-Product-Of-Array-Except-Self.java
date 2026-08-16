import java.util.Arrays;
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        int[] arr = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(post, 1);
        Arrays.fill(arr, 1);
        post[n - 1] = nums[n - 1];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] * pre[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i];
        }
        arr[0] = post[1];
        arr[n - 1] = pre[n - 2];
        for (int i = 1; i < n - 1; i++) {
            arr[i] = post[i + 1]*pre[i - 1];
        }
        return arr;
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        Solution sol = new Solution();

        int[] result = sol.productExceptSelf(nums);

        System.out.println(Arrays.toString(result));
    }
}