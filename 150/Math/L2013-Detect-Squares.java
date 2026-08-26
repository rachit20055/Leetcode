
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DetectSquares {
    Map<String,Integer> ptsCount;
    List<int[]> pts;

    public DetectSquares(){
        ptsCount=new HashMap<>();
        pts=new ArrayList<>();
    }

    public void add(int[] point){
        String key=point[0]+","+point[1];
        ptsCount.put(key,ptsCount.getOrDefault(key,0)+1);
        pts.add(point);
    }

    public int count(int[] point){
        int res=0;
        int px=point[0];
        int py=point[1];

        for(int[] p:pts){
            int x=p[0];
            int y=p[1];

            if(Math.abs(py-y)!=Math.abs(px-x)||x==px||y==py)continue;

            res+=getCount(x,py)*getCount(px,y);
        }

        return res;
    }

    public int getCount(int x,int y){
        String key=x+","+y;
        return ptsCount.getOrDefault(key,0);
    }
    public static void main(String[] args){
        DetectSquares obj=new DetectSquares();
        obj.add(new int[]{3,10});
        obj.add(new int[]{11,2});
        obj.add(new int[]{3,2});
        obj.add(new int[]{11,10});
        System.out.println(obj.count(new int[]{3,10}));
        obj.add(new int[]{11,2});
        System.out.println(obj.count(new int[]{3,10}));
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */