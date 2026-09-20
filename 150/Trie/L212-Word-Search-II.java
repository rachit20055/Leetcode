
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrieNode
{
    HashMap<Character,TrieNode> children;
    Boolean isWord;
    TrieNode()
    {
        children=new HashMap<>();
        isWord=false;
    }
    void addWord(String word,TrieNode root)
    {
        TrieNode curr=root;
        for(char ch:word.toCharArray())
        {
            if(!curr.children.containsKey(ch))
            {
                curr.children.put(ch,new TrieNode());
            }
            curr=curr.children.get(ch);
        }
        curr.isWord=true;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        for(String w: words)
        {
            root.addWord(w,root);
        }
        int rows=board.length;
        int cols=board[0].length;
        Set<String> res=new HashSet<>();
        boolean[][] visit=new boolean[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                dfs(board,i,j,rows,cols,visit,res,"",root);
            }
        }
        return new ArrayList<>(res);
    }
    void dfs(char board[][],int r,int c,int rows,int cols,boolean[][] visit,Set<String> res,String word,TrieNode curr)
    {
        if(r<0||c<0||r==rows||c==cols||visit[r][c]==true||!curr.children.containsKey(board[r][c]))
        {
            return;
        }
        visit[r][c]=true;
        curr=curr.children.get(board[r][c]);
        word+=board[r][c];
        if(curr.isWord==true)
        {
            res.add(word);
        }
        dfs(board,r-1,c,rows,cols,visit,res,word,curr);
        dfs(board,r,c-1,rows,cols,visit,res,word,curr);
        dfs(board,r+1,c,rows,cols,visit,res,word,curr);
        dfs(board,r,c+1,rows,cols,visit,res,word,curr);
        visit[r][c]=false;
    }
    public static void main(String[] args){
        //LeetCode 212: Word Search II
        Solution sol=new Solution();
        //Test Case 1
        char[][] board1={
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words1={"oath","pea","eat","rain"};
        List<String> result1=sol.findWords(board1,words1);
        System.out.println("Test 1 Result:"+result1); //Expected: [oath, eat]
        //Test Case 2
        char[][] board2={
            {'a','b'},
            {'c','d'}
        };
        String[] words2={"abcb"};
        List<String> result2=sol.findWords(board2,words2);
        System.out.println("Test 2 Result:"+result2); //Expected: []
    }
}