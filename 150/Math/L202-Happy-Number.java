
import java.util.HashSet;
import java.util.Set;
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        int sum=n;
        while(true)
        {
            if(sum==1)
            {
                return true;
            }
            if(set.contains(sum))
            {
                return false;
            }
            set.add(sum);
            sum=sumofD(sum);
        }
    }
    public int sumofD(int n)
    {
        int sum=0;
        while(n!=0)
        {
            sum+=Math.pow(n%10,2);
            n=n/10;
        }
        return sum;
    }
     public static void main(String[] args){
        Solution obj=new Solution();
        int n=19;
        System.out.println(obj.isHappy(n));
    }
}