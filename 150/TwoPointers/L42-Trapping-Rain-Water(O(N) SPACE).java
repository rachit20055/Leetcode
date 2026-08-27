class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }
        int maxLeft[] = new int[n];
        int maxRight[] = new int[n];
        maxLeft[0] = 0;
        maxRight[n - 1] = 0;
        for (int i=1;i<n;i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i=n-2;i>=0;i--) {
            maxRight[i]=Math.max(maxRight[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int water = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (water > 0) {
                sum += water;
            }
        }
        return sum;
    }
     public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution sol = new Solution();
        int result = sol.trap(height);
        System.out.println(result);
    }
}