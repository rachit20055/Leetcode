class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        int n=s.length();
        StringBuffer sb=new StringBuffer();
        int j=n;
        for(int i=n-1;i>=0;i--)
        {
           if(i==0)
           {
             String t=s.substring(i,j);
                sb.append(t);
           } 
           else if(s.charAt(i)==' ')
           {
             
             if(i+1!=j)
             {
                String t=s.substring(i+1,j);
                sb.append(t);
                sb.append(" ");
             }
             j=i;
           }
        }
        return sb.toString().trim();
    }
    
}