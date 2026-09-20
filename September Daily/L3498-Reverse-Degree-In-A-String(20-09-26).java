class Solution {
    public int reverseDegree(String s) {
        int res=0;
        int i=1;
        for(char ch: s.toCharArray())
        {
            res+=(26-(ch-'a'))*i;
            i++;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol=new Solution();

        //Example 1
        String s1="abc";
        System.out.println("Example 1 Result:"+sol.reverseDegree(s1)); //Expected: 148

        //Example 2
        String s2="zaza";
        System.out.println("Example 2 Result:"+sol.reverseDegree(s2)); //Expected: 160
    }
}