class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> a=new ArrayList<>();
        int m=p.length();
        int n=s.length();
        if(m>n)
        {
            return a;
        }
        int count[]=new int[26];
        int winCount[]=new int[26];
        for(int i=0;i<m;i++)
        {
            count[p.charAt(i)-'a']++;
            winCount[s.charAt(i)-'a']++;
        }
        if(match(count,winCount))
        {
            a.add(0);
        }
        int left=0;
        for(int right=m;right<n;right++)
        {
            winCount[s.charAt(right)-'a']++;
            winCount[s.charAt(left)-'a']--;
            left++;
            if(match(count,winCount))
            {
                a.add(left);
            }
        }
        return a;
    }
    boolean match(int a[],int b[])
    {
        for(int i=0;i<26;i++)
        {
            if(a[i]!=b[i])
            {
                return false;
            }
        }
        return true;
    }
}