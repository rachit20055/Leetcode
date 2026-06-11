class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int j=0;
        for (int i=0;i<=s.length();i++) 
        {
            if(i==s.length()||s.charAt(i)==' ') 
            {
                for (int k=i-1;k>=j;k--)
                {
                    sb.append(s.charAt(k));
                }
                if(i!=s.length())
                {
                    sb.append(' ');
                }
                j=i+1;
            }
        }

        return sb.toString();
    }
}