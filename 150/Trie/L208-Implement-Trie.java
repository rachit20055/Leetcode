
import java.util.HashMap;
import java.util.Map;

class TrieNode{
    Map<Character,TrieNode> children;
    boolean endOfWord;
    public TrieNode(){
        children=new HashMap<>();
        endOfWord=false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
       root=new TrieNode();
    }
    public void insert(String word) {
        TrieNode curr=new TrieNode();
        curr=root;
        for(char ch:word.toCharArray())
        {
            if(!curr.children.containsKey(ch))
            {
                curr.children.put(ch,new TrieNode());
            }
            curr=curr.children.get(ch);
        }
        curr.endOfWord=true;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray())
        {
            if(curr.children.containsKey(ch))
            {
                curr=curr.children.get(ch);
            }
            else
            {
               return false;
            }
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char ch:prefix.toCharArray())
        {
            if(curr.children.containsKey(ch))
            {
                curr=curr.children.get(ch);
            }
            else
            {
               return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        //LeetCode 208: Implement Trie (Prefix Tree)
        Trie trie=new Trie();

        System.out.println("--- Running LeetCode 208 Example 1 ---");
        
        //Step 1: Insert "apple"
        trie.insert("apple");
        System.out.println("Inserted: apple");

        //Step 2: Search "apple" -> expected true
        boolean test1=trie.search("apple");
        System.out.println("search(\"apple\"):"+test1); //Expected: true

        //Step 3: Search "app" -> expected false (only prefix, not complete word)
        boolean test2=trie.search("app");
        System.out.println("search(\"app\"):"+test2); //Expected: false

        //Step 4: StartsWith "app" -> expected true
        boolean test3=trie.startsWith("app");
        System.out.println("startsWith(\"app\"):"+test3); //Expected: true

        //Step 5: Insert "app"
        trie.insert("app");
        System.out.println("Inserted: app");

        //Step 6: Search "app" again -> expected true
        boolean test4=trie.search("app");
        System.out.println("search(\"app\"):"+test4); //Expected: true

        System.out.println("--- Additional Edge Cases ---");
        
        //Step 7: Search non-existent prefix/word
        System.out.println("search(\"appl\"):"+trie.search("appl")); //Expected: false
        System.out.println("startsWith(\"b\"):"+trie.startsWith("b")); //Expected: false
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */