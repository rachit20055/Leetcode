import java.util.ArrayList;
import java.util.List;
class combination_sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> a=new ArrayList<>();
        List<Integer> s=new ArrayList<>();
        sum(s,a,target,0,candidates);
        return a;
    }
    public void sum(List<Integer> s,List<List<Integer>> res,int current,int i,int a[])
    {
        if(current<0||i==a.length)
        {
            return;
        }
        if(current==0)
        {
            res.add(new ArrayList<>(s));
            return;
        }
        s.add(a[i]);
        sum(s,res,current-a[i],i,a);

        s.remove(s.size()-1);
        sum(s,res,current,i+1,a);
        
    }
    public static void main(String args[])
    {
        combination_sum obj=new combination_sum();
        int arr[]={2,3,6,7};
        List<List<Integer>> res=obj.combinationSum(arr,7);
        System.out.println("The Result:");
        for(int i=0;i<res.size();i++)
        {
            for(int j=0;j<res.get(i).size();j++)
            {
                System.out.print(res.get(i).get(j)+",");
            }
            System.out.println();
        }
    }
}