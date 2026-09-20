class Main{
    public static void main(String[] args){
        Solution sol=new Solution();

        //Test Case 1: Overlapping
        System.out.println("Test 1 Result:"+sol.checkOverlap(1,0,0,1,-1,3,1)); //Expected: true

        //Test Case 2: Circle inside rectangle
        System.out.println("Test 2 Result:"+sol.checkOverlap(1,1,1,1,-3,2,-1)); //Expected: false

        //Test Case 3: Tangent / Touching
        System.out.println("Test 3 Result:"+sol.checkOverlap(1,0,0,-1,0,0,1)); //Expected: true
    }
}
class Solution{
    public boolean checkOverlap(int radius,int xCenter,int yCenter,int x1,int y1,int x2,int y2){
        //Clamp xCenter to [x1, x2]
        int nearestX=Math.max(x1,Math.min(xCenter,x2));
        //Clamp yCenter to [y1, y2]
        int nearestY=Math.max(y1,Math.min(yCenter,y2));

        int dx=nearestX-xCenter;
        int dy=nearestY-yCenter;

        //Check if squared distance is within radius squared
        return dx*dx+dy*dy<=radius*radius;
    }
}