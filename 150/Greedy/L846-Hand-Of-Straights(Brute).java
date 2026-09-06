
import java.util.Arrays;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0)
        {
            return false;
        }
        Arrays.sort(hand);
        boolean[] used=new boolean[hand.length];
        for(int i=0;i<hand.length;i++){
            if(used[i]){
                continue;
            }
            int prev=hand[i];
            used[i]=true;
            for(int count=1;count<groupSize;count++)
            {
                boolean found=false;
                for(int j=i+1;j<hand.length;j++)
                {
                    if(!used[j]&&hand[j]==prev+1)
                    {
                        used[j]=true;
                        prev=hand[j];
                        found=true;
                        break;
                    }
                }
                if(!found) 
                { 
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] hand={1,2,3,6,2,3,4,7,8};
        int groupSize=3;
        boolean result=s.isNStraightHand(hand,groupSize);
        System.out.println(result);
    }
}