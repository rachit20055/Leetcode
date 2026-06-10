class Solution {
    public boolean repeatedSubstringPattern(String s) 
    {
        int n = s.length();
        for (int l=1;l<= n/2;l++) 
        {
            if(n%l!= 0) 
            {
                continue;
            }
            String sub = s.substring(0,l);
            StringBuilder sb = new StringBuilder();
            int r=n/l;
            for (int i=0;i<r;i++) 
            {
                sb.append(sub);
            }
            if (sb.toString().equals(s)) 
            {
                return true;
            }
        }
        return false;
    }
}