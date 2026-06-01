class Solution {
    public int[] twoSum(int[] n, int t) {
        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[i] + n[j] == t) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
