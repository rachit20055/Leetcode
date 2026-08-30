
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates,int target) {
        List<List<Integer>>a=new ArrayList<>();
        List<Integer>s=new ArrayList<>();
        Arrays.sort(candidates);
        sum(s,a,target,0,candidates);
        return a;
    }
    public void sum(List<Integer>s,List<List<Integer>>res,int current,int i,int a[]) {
        if(current==0){
            res.add(new ArrayList<>(s));
            return;
        }
        if(current<0||i==a.length){
            return;
        }
        for(int j=i;j<a.length;j++){
            if(j>i&&a[j]==a[j-1]){
                continue;
            }

            if(a[j]>current){
                break;
            }
            s.add(a[j]);
            sum(s,res,current-a[j],j+1,a);
            s.remove(s.size()-1);
        }
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> result=s.combinationSum2(candidates,target);
        System.out.println(result);
    }
}