
import java.util.Arrays;
import java.util.List;

class wordBreak
{
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return check(0,s,wordDict,dp);
    }
    public boolean check(int i, String s, List<String> word,int[] arr)
    {
        if(i==s.length())
        {
            return true;
        }
        if (arr[i] != -1)
                  return arr[i] == 1;
        for (int k = 0; k < word.size(); k++) {
            if (matched(s, word.get(k), i))
            {
                if (check(i + word.get(k).length(), s, word,arr)) {
                    arr[i]=1;
                    return true;
                }
            }
        }
        arr[i]=0;
        return false;
    }

    public boolean matched(String word, String match, int start)
    {
        int i=start;
        int j=0;
        int m=word.length();
        int n=match.length();
        if(m-start<n)
        {
            return false;
        }
        while(i<m&&j<n)
        {
            if(word.charAt(i)!=match.charAt(j))
            {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
    public static void main(String[] args) {
        wordBreak obj=new wordBreak();
        System.out.println(obj.wordBreak("leetcodeandtheballsaresohard",List.of("leet","andthe","code","ball","word","cold","so","are","s","ha","hard")));
    }
}