class Solution {
    public int maxArea(int[] height) {
        return max(height);
    }
    int max(int[] a)
    {
        int i=a.length-1;
        int j=0;
        int k=i;
        int area;
        int max=0;
        while(i!=j)
        {
            area=k*Math.min(a[i],a[j]);
            max=Math.max(max,area);
            if(a[i]>a[j])
            {
                j++;
            }
            else
            {
                i--;
            }
            k--;
            
        }
        return max;
    }
}