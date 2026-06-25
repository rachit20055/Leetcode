class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        int i=0;
        StringBuffer sb=new StringBuffer("");
        if(n==1)
        {
            return false;
        }
        int k=-1;
        while(i<n)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
            {
                sb.append(s.charAt(i));
                k++;
            }
            else if(s.charAt(i)==')')
            {
                if(k<0||sb.charAt(k)!='(')
                {
                     return false;
                }
                else
                {
                    sb.deleteCharAt(k);
                    k--;
                }
            }
            else if(s.charAt(i)==']')
            {
                if( k<0||sb.charAt(k)!='[')
                {
                     return false;
                }
                else
                {
                    sb.deleteCharAt(k);
                    k--;
                }
            }
            else if(s.charAt(i)=='}')
            {
                if( k<0||sb.charAt(k)!='{')
                {
                     return false;
                }
                else
                {
                    sb.deleteCharAt(k);
                    k--;
                }
            }
            i++;
        }
        return sb.length()==0?true:false;
}
}