class Solution {
    public int countCommas(int n) {
        if(n<1000)
        {
            return 0;
        }
        int sum=0;
        for(int i=1000;i<=n;i++)
        {
            sum+=com(i);
        }
        return sum;
        
    }
    public int com(int n)
    {
        if(n<1000000)
        {
            return 1;
        }
        if(n<1000000000)
        {
            return 2;
        }
        int commas=0;
        while(n!=0)
        {
            if(n/1000!=0)
            {
                commas++;
            }
            n=n/1000;
        }
        return commas;
    }
//     class Solution {
//     public int countCommas(int n) {
//         return Math.max(0,n-999);
//     }
// }
    public static void main(String[] args){
        Solution s=new Solution();
        int n=1002;
        int result=s.countCommas(n);
        System.out.println(result);
    }
}