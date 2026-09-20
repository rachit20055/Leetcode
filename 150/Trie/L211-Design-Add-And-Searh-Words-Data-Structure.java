
import java.util.HashMap;
class word
{
    HashMap<Character,word> children;
    boolean end;
    word()
    {
        children=new HashMap<>();
        end=false;
    }
}
class WordDictionary{
    word root;
    public WordDictionary() {
        root=new word();
    }
    public void addWord(String word) {
        word curr=root;
        for(char ch:word.toCharArray())
        {
            if(!curr.children.containsKey(ch))
            {
               curr.children.put(ch,new word());
            }
            curr=curr.children.get(ch);
        }
        curr.end=true;
    }
    public boolean search(String word) {
        return dfs(word,0,root);
    }
    boolean dfs(String word,int index,word curr)
    {
        if(index==word.length())
        {
            return curr.end;
        }
        char ch=word.charAt(index);
        if(ch=='.')
        {
            for(word child:curr.children.values()){
                if(dfs(word,index+1,child)){
                    return true;
                }
            }
            return false;
        }else{
            if(!curr.children.containsKey(ch)){
                return false;
            }
            return dfs(word,index+1,curr.children.get(ch));
        }
    }
    public static void main(String[] args){
        //LeetCode 211: Design Add and Search Words Data Structure
        WordDictionary wordDictionary=new WordDictionary();
        //Step 1: Add words
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println("Added words: bad, dad, mad");
        //Step 2: Exact search tests
        System.out.println("search(\"pad\"):"+wordDictionary.search("pad")); //Expected: false
        System.out.println("search(\"bad\"):"+wordDictionary.search("bad")); //Expected: true
        //Step 3: Wildcard '.' searches
        System.out.println("search(\".ad\"):"+wordDictionary.search(".ad")); //Expected: true (matches bad, dad, mad)
        System.out.println("search(\"b..\"):"+wordDictionary.search("b..")); //Expected: true (matches bad)
        System.out.println("search(\"...\"):"+wordDictionary.search("...")); //Expected: true (matches bad, dad, mad)
        System.out.println("search(\"..b\"):"+wordDictionary.search("..b")); //Expected: false
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */