class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0,max=0;
        int[] a=new int[256];
        Arrays.fill(a,-1);
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(a[c]>=l)
            {
                l=a[c]+1;
            }
            a[c]=i;
            max=Math.max(max,i-l+1);
        }
        return max;
    }
}