class Solution {
     public String multiply(String num1,String num2){
        if(num1.equals("0")||num2.equals("0"))
        { return "0";
        }
        int m=num1.length();
        int n=num2.length();
        int[] arr=new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int a=num1.charAt(i)-'0';
                int b=num2.charAt(j)-'0';
                int product=a*b+arr[i+j+1];
                arr[i+j+1]=product%10;
                arr[i+j]+=product/10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int num:arr){
            if(sb.length()==0&&num==0)continue;
            sb.append(num);
        }
        return sb.toString();
    }
     public static void main(String[] args){
        Solution obj=new Solution();
        String num1="123";
        String num2="45";
        System.out.println(obj.multiply(num1,num2));
    }
}