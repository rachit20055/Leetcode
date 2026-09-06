
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean isNStraightHand(int[] hand,int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0) 
        {
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int card:hand)
         {   map.put(card,map.getOrDefault(card,0)+1);
         }
        for(int card:hand){
            if(map.get(card)==0) 
            { continue;
            }
            for(int i=0;i<groupSize;i++)
            {
                int curr=card+i;
                if(map.getOrDefault(curr,0)==0)
                { 
                      return false;
                }
                map.put(curr,map.get(curr)-1);
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