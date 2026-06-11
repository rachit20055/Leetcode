class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> a=new ArrayList<>();
        if(n==1)
        {
            return List.of("()");
        }
        helper(a,"",0,0,n);
        return a;
    }
    void helper(List<String> n, String s, int open,int close,int need)
    {
        if(s.length()==2*need)
        {
           n.add(s);
           return;
        }
        if(open<need)
        {
            helper(n,s+"(",open+1,close,need);
        }
        if(close<open)
        {
            helper(n,s+")",open,close+1,need);
        }
    }
}