class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.max(rec1[0],rec2[0])<Math.min(rec1[2],rec2[2])&&Math.max(rec1[1],rec2[1])<Math.min(rec1[3],rec2[3]);
    }
    public static void main(String[] args)
    {
        Solution s=new Solution();
        System.out.println(s.isRectangleOverlap(new int[]{1,1,0,1},new int[]{2,2,3,3}));
    }
}