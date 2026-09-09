class Solution {
    public long countCommas(long n) {
        long res=0;
        for(long i=1000;i<=n;i=i*1000)
        {
            res+=n-i+1;
        }
        return res;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        long result=s.countCommas(1000000000);
        System.out.println(result);
    }
}