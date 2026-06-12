class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.length()<2) 
        {return s;
        }

        int start=0;
        int maxLen=1;
        for(int i=0;i<s.length();i++)
        {
            int l=a(s,i,i);
            int ll=a(s,i,i+1);
            int len=Math.max(l,ll);
            if(len>maxLen)
            {
                maxLen=len;
                start=i-(len-1)/2;
            }
        }
        return s.substring(start,start+maxLen);
    }
    public int a(String s, int left, int right)
    {
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        return right-left-1;
    }
}