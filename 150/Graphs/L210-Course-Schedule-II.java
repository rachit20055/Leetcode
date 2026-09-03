
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    List<Integer> res=new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer> visited=new HashSet<>();
        HashSet<Integer> cycle=new HashSet<>();
        List<List<Integer>> preMap=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            preMap.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            preMap.get(p[0]).add(p[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,cycle,visited,preMap)){
                return new int[0];
            }
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
    public boolean dfs(int crs,HashSet<Integer> cycle, HashSet<Integer> visit,List<List<Integer>> preMap)
    {
        if(cycle.contains(crs))
        {
            return false;
        }
        if(visit.contains(crs))
        {
            return true;
        }
        cycle.add(crs);
        for(int i=0;i<preMap.get(crs).size();i++)
        {
            if(dfs(preMap.get(crs).get(i),cycle,visit,preMap)==false)
            {
                return false;
            }
        }
        cycle.remove(crs);
        visit.add(crs);
        res.add(crs);
        return true;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int numCourses=4;
        int[][] prerequisites={
            {1,0},
            {2,0},
            {3,1},
            {3,2}
        };
        int[] result=s.findOrder(numCourses,prerequisites);
        System.out.println(Arrays.toString(result));
    }
}