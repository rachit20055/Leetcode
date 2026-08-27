import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<numbers.length;i++) {
            int comp=target-numbers[i];
            if (map.containsKey(comp)) {
                return new int[]{map.get(comp) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        Solution sol = new Solution();
        int[] result = sol.twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }
}