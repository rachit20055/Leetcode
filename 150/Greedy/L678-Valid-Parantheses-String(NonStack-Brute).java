class Solution {
    public boolean checkValidString(String s) {
        return check(s,0,0);
    }
    public boolean check(String s,int i,int open) {
        if(open<0)
        {
            return false;
        }
        if(i==s.length())
        {
            return open==0;
        }
        if(s.charAt(i)=='(')
        {
            return check(s,i+1,open+1);
        }
        if(s.charAt(i)==')')
        {
            return check(s,i+1,open-1);
        }
        return check(s,i+1,open+1)||check(s,i+1,open-1)||check(s,i+1,open);
    }
    public static void main(String[] args){
        Solution s=new Solution();
        String str="(*)";
        boolean result=s.checkValidString(str);
        System.out.println(result);
    }
}