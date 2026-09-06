class Solution {
    public int canCompleteCircuit(int[] gas,int[] cost) {
        int n=gas.length;
        int[] diff=new int[n];
        for(int i=0;i<n;i++){
            diff[i]=gas[i]-cost[i];
        }
        for(int start=0;start<n;start++){
            int tank=0;
            boolean possible=true;
            for(int i=0;i<n;i++){
                int index=(start+i)%n;
                tank+=diff[index];
                if(tank<0){
                    possible=false;
                    break;
                }
            }
            if(possible) 
            {  
                return start;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] gas={1,2,3,4,5};
        int[] cost={3,4,5,1,2};
        int result=s.canCompleteCircuit(gas,cost);
        System.out.println(result);
    }
}