
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            if(digits[i]%2==1)
            {
                continue;
            }
            for(int j=0;j<n;j++)
            {
                if(i==j)
                {
                    continue;
                }
                for(int k=0;k<n;k++)
                {
                    if(digits[k]==0||i==k||k==j)
                    {
                        continue;
                    }
                    set.add(digits[i]+(digits[j]*10)+(digits[k]*100));
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args)
    {
        Solution s=new Solution();
        System.out.println(s.totalNumbers(new int[]{1,2,3,4,5,6,7,8,9,0}));    
    }
}