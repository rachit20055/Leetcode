
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int n = digits.length();
        int total = 1;
        for (int i = 0; i < n; i++) {
            total *= map[digits.charAt(i) - '0'].length();
        }
        for (int i = 0; i < total; i++) {
            int num = i;
            StringBuilder sb = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                String s = map[digits.charAt(j) - '0'];
                sb.insert(0, s.charAt(num % s.length()));
                num /= s.length();
            }
            res.add(sb.toString());
        }
        return res;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        String digits="23";
        List<String> result=s.letterCombinations(digits);
        System.out.println(result);
    }
}