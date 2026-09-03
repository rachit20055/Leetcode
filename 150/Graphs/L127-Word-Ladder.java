import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        if(!wordList.contains(endWord))
        {
            return 0;
        }
        Map<String,List<String>> nei=new HashMap<>();
        wordList.add(beginWord);
        for(String word:wordList)
        {
            for(int i=0;i<word.length();i++)
            {
                String pattern=word.substring(0,i)+"*"+word.substring(i+1);
                nei.computeIfAbsent(pattern,k->new ArrayList<>()).add(word);
            }
        } 
        Set<String> visit=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        visit.add(beginWord);
        q.offer(beginWord);
        int res=1;
        while(!q.isEmpty())
        {
           int size=q.size();
           for(int i=0;i<size;i++)
           {
                String word=q.poll();
                if(word.equals(endWord)){
                    return res;
                }
                for(int j=0;j<word.length();j++)
                {
                    String pattern=word.substring(0,j)+"*"+word.substring(j+1);
                    for(String newWord:nei.getOrDefault(pattern,new ArrayList<>()))
                    {
                        if(!visit.contains(newWord))
                        {
                            visit.add(newWord);
                            q.offer(newWord);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        String beginWord="hit";
        String endWord="cog";
        List<String> wordList=new ArrayList<>(
            Arrays.asList("hot","dot","dog","lot","log","cog")
        );
        int result=s.ladderLength(beginWord,endWord,wordList);
        System.out.println(result);
    }
}