class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int arr[]=new int[26];
        int m=ransomNote.length();
        int n=magazine.length();
        for(int i=0;i<n;i++)
        {
            arr[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<m;i++)
        {
            arr[ransomNote.charAt(i)-'a']--;
            if(arr[ransomNote.charAt(i)-'a']<0)
            {
                return false;
            }
        }
        return true;
    }
}