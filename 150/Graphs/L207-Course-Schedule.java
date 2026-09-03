
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean canFinish(int numCourses,int[][] prerequisites){
        List<List<Integer>> preMap=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            preMap.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            int crs=p[0];
            int pre=p[1];
            preMap.get(crs).add(pre);
        }
        Set<Integer> visitSet=new HashSet<>();
        for(int crs=0;crs<numCourses;crs++){
            if(!dfs(crs,preMap,visitSet)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int crs,List<List<Integer>> preMap,Set<Integer> visitSet){
        if(visitSet.contains(crs)){
            return false;
        }
        if(preMap.get(crs).isEmpty()){
            return true;
        }
        visitSet.add(crs);
        for(int pre:preMap.get(crs)){
            if(!dfs(pre,preMap,visitSet)){
                return false;
            }
        }
        visitSet.remove(crs);
        preMap.get(crs).clear();
        return true;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int numCourses=2;
        int[][] prerequisites={{1,0}};
        System.out.println(s.canFinish(numCourses,prerequisites));
    }
}