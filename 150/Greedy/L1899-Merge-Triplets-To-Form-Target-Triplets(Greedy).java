class Solution {
    public boolean mergeTriplets(int[][] triplets,int[] target) {
        boolean[] found=new boolean[3];
        for(int[] triplet:triplets){
            if(triplet[0]>target[0]||triplet[1]>target[1]||triplet[2]>target[2])
            {
                continue;
            }
            for(int i=0;i<3;i++)
            {
                if(triplet[i]==target[i])
                {
                    found[i]=true;
                }
            }
        }
        return found[0]&&found[1]&&found[2];
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