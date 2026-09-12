
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    class Node 
    {
        long sum;
        List<Integer> list;
        Node(long sum,List<Integer> list) {
            this.sum=sum;
            this.list=list;
        }
    }
    int[][] a;
    Node[][] dp;
    int n;
    public int[] maximumWeight(List<List<Integer>> intervals) {
        n=intervals.size();
        a=new int[n][4];
        for(int i=0;i<n;i++)
        {
            a[i][0]=intervals.get(i).get(0);
            a[i][1]=intervals.get(i).get(1);
            a[i][2]=intervals.get(i).get(2);
            a[i][3]=i;
        }
        Arrays.sort(a,(x,y)->Integer.compare(x[0],y[0]));
        dp=new Node[n+1][5];
        Node ans=dfs(0,4);
        int[] res=new int[ans.list.size()];
        for(int i=0;i<ans.list.size();i++)
        {
            res[i]=ans.list.get(i);
        }
        return res;
    }
    Node dfs(int i,int k) {
        if(i==n||k==0)
        {
            return new Node(0,new ArrayList<>());
        }
        if(dp[i][k]!=null)
        {
            return dp[i][k];
        }
        Node skip=dfs(i+1,k);
        int next=find(i);
        Node temp=dfs(next,k-1);
        List<Integer> list=new ArrayList<>(temp.list);
        list.add(a[i][3]);
        Collections.sort(list);
        Node take=new Node(a[i][2]+temp.sum,list);
        if(take.sum>skip.sum)
        {
            return dp[i][k]=take;
        }
        if(take.sum<skip.sum)
        {
            return dp[i][k]=skip;
        }
        if(compare(take.list,skip.list)<0)
        {
            return dp[i][k]=take;
        }
        return dp[i][k]=skip;
    }
    int find(int i) {
        int l=i+1;
        int r=n;
        int end=a[i][1];
        while(l<r){
            int mid=(l+r)/2;
            if(a[mid][0]<=end)
            {
                l=mid+1;
            }
            else
                r=mid;
        }
        return l;
    }
    int compare(List<Integer> a,List<Integer> b) 
    {
        int n=Math.min(a.size(),b.size());
        for(int i=0;i<n;i++)
        {
            if(!a.get(i).equals(b.get(i)))
            {
                return Integer.compare(a.get(i),b.get(i));
            }
        }
        return Integer.compare(a.size(),b.size());
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        List<List<Integer>> intervals=new ArrayList<>();
        intervals.add(Arrays.asList(1,3,2));
        intervals.add(Arrays.asList(4,5,2));
        intervals.add(Arrays.asList(1,5,5));
        intervals.add(Arrays.asList(6,9,3));
        intervals.add(Arrays.asList(6,7,1));
        intervals.add(Arrays.asList(8,9,1));
        int[] result=s.maximumWeight(intervals);
        System.out.println(Arrays.toString(result));
    }
}