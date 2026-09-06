class Solution {
    public boolean mergeTriplets(int[][] triplets,int[] target) {
        return solve(triplets,target,0,0,0,0);
    }
    public boolean solve(int[][] triplets,int[] target,int i,int a,int b,int c) {
        if(a>target[0]||b>target[1]||c>target[2])
        {
            return false;
        }
        if(i==triplets.length)
        {
            return a==target[0]&&b==target[1]&&c==target[2];
        }
        if(solve(triplets,target,i+1,a,b,c))
        {
            return true;
        }
        return solve(triplets,target,i+1,Math.max(a,triplets[i][0]),Math.max(b,triplets[i][1]),Math.max(c,triplets[i][2]));
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[][] triplets={
            {2,5,3},
            {1,8,4},
            {1,2,5}
        };
        int[] target={2,5,5};
        boolean result=s.mergeTriplets(triplets,target);
        System.out.println(result);
    }
}