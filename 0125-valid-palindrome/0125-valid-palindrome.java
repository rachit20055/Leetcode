class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb=new StringBuffer();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                sb.append(Character.toLowerCase(c));
            }        
        }
        String s1=sb.toString();
        String s2=sb.reverse().toString();
        return s1.equals(s2);
        
    }
}