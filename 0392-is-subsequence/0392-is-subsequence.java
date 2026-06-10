class Solution {
    public boolean isSubsequence(String s, String t) {
          int n=s.length();
          int m=t.length();
          int i=0;
          int j=0;
          while(i<m)
          {
            if(j==n)
            {
                return true;
            }
            if(s.charAt(j)==t.charAt(i))
            {
                j++;
            }
            i++;
          }
          return j==n;
    }
}