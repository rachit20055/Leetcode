class Solution {
    public int minDistance(String word1,String word2) {
        int[][] cache=new int[word1.length()+1][word2.length()+1];
        for(int j=0;j<=word2.length();j++) 
        {
            cache[word1.length()][j]=word2.length()-j;
        }
        for(int i=0;i<=word1.length();i++) 
        {
            cache[i][word2.length()]=word1.length()-i;
        }
        for(int i=word1.length()-1;i>=0;i--) 
        {
            for(int j=word2.length()-1;j>=0;j--) 
            {
                if(word1.charAt(i)==word2.charAt(j)) 
                {
                    cache[i][j]=cache[i+1][j+1];
                }
                else 
                {
                    cache[i][j]=1+Math.min(cache[i+1][j],Math.min(cache[i][j+1],cache[i+1][j+1]));
                }
            }
        }
        return cache[0][0];
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int n=s.minDistance("derohwse","rose");
        System.out.println(n);
    }
}