class Solution {
    public int canCompleteCircuit(int[] gas,int[] cost) {
       int sumgas=0,costgas=0;
       int n=gas.length;
       for(int i=0;i<n;i++)
        {
         sumgas+=gas[i];
         costgas+=cost[i];
        }
        if(sumgas<costgas)
        {
             return -1;
        }
       int total=0;
       int res=0;
       for(int i=0;i<n;i++)
       {
          total+=gas[i]-cost[i];
          if(total<0)
          {
            total=0;
            res=i+1;
          }
       }
       return res;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] gas={1,2,3,4,5};
        int[] cost={3,4,5,1,2};
        int result=s.canCompleteCircuit(gas,cost);
        System.out.println(result);
    }
}