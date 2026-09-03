import java.util.*;
class Node{
    int val;
    List<Node> neighbors;

    Node(int val){
        this.val=val;
        this.neighbors=new ArrayList<>();
    }
}
class Solution{
    Map<Node,Node> oldToNew=new HashMap<>();

    public Node cloneGraph(Node node){
        if(node==null)return null;

        if(oldToNew.containsKey(node)){
            return oldToNew.get(node);
        }

        Node copy=new Node(node.val);
        oldToNew.put(node,copy);

        for(Node nei:node.neighbors){
            copy.neighbors.add(cloneGraph(nei));
        }

        return copy;
    }
    public static void main(String[] args){

        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Solution s=new Solution();

        Node clone=s.cloneGraph(n1);

        printGraph(clone);
    }

    static void printGraph(Node node){
        Set<Node> visited=new HashSet<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(node);
        visited.add(node);
        while(!q.isEmpty()){
            Node curr=q.poll();
            System.out.print(curr.val+" -> ");
            for(Node nei:curr.neighbors){
                System.out.print(nei.val+" ");
                if(!visited.contains(nei)){
                    visited.add(nei);
                    q.offer(nei);
                }
            }
            System.out.println();
        }
    }
}