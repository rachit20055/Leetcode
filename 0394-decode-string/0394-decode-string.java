class Solution {
    public String decodeString(String s) {
        Stack<Integer> n=new Stack<>();
        Stack<StringBuilder> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int num=0;
        for(int i=0;i<s.length();i++) 
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
                num=num*10+(ch-'0');
            }
            else if(ch=='[') 
            {
                n.push(num);
                st.push(sb);
                num=0;
                sb=new StringBuilder();
            }
            else if(ch==']') 
            {
                int k=n.pop();
                StringBuilder p=st.pop();
                for(int j=0;j<k;j++) 
                {
                    p.append(sb);
                }
                sb=p;
            }
            else 
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}