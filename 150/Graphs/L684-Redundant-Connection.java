import java.util.Arrays;
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
         int n=edges.length;
         int[] parent=new int[n+1];
         for(int i=0;i<n;i++)
         {
              parent[i]=i;
         }
         int rank[]=new int[n+1];
         Arrays.fill(rank,1);
         for(int i=0;i<n;i++)
         {       if(!union(edges[i][0],edges[i][1],parent,rank))
                {
                    return new int[]{edges[i][0],edges[i][1]};
                }
         }
         return new int[]{};
    }
    public int find(int n,int[] parent)
    {
        int p=parent[n];
        while(p!=parent[p])
        {
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }
    public boolean union(int n1, int n2,int parent[],int rank[])
    {
        int p1=find(n1,parent);
        int p2=find(n2,parent);
        if(p1==p2)
        {
            return false;
        }
        if(rank[p1]>rank[p2])
        {
            parent[p2]=p1;
            rank[p1]+=rank[p2];
        }
        else
        {
            parent[p1]=p2;
            rank[p2]+=rank[p1];
        }
        return true;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[][] edges={
            {1,2},
            {1,3},
            {2,3}
        };
        int[] result=s.findRedundantConnection(edges);
        System.out.println(Arrays.toString(result));
    }
}