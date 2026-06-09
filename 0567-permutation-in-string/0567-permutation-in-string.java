class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        if(m>n)
        {
            return false;
        }
        int count[]=new int[26];
        int winCount[]=new int[26];
        for(int i=0;i<m;i++)
        {
            count[s1.charAt(i)-'a']++;
            winCount[s2.charAt(i)-'a']++;
        }
        if(match(count,winCount))
        {
            return true;
        }
        int left = 0;
        for (int right = m; right < n; right++) 
        {
             winCount[s2.charAt(right) - 'a']++;
             winCount[s2.charAt(left) - 'a']--;
             left++;
             if (match(count, winCount)) 
             {
               return true;
             }
        }
        return false;
    }
    boolean match(int[] a, int[] b)
    {
        for (int i = 0; i < 26; i++) 
        {
            if (a[i] != b[i]) 
            {
                return false;
            }
        }
        return true;
    }
}