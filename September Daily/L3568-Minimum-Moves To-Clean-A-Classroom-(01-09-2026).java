import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Main{
    public static void main(String[] args){
        Solution sol=new Solution();

        //Example 1
        String[] classroom1={"S.","XL"};
        System.out.println("Example 1 Result:"+sol.minMoves(classroom1,2)); //Expected: 2

        //Example 2
        String[] classroom2={"LS","RL"};
        System.out.println("Example 2 Result:"+sol.minMoves(classroom2,4)); //Expected: 3

        //Example 3
        String[] classroom3={"L.S","RXL"};
        System.out.println("Example 3 Result:"+sol.minMoves(classroom3,3)); //Expected: -1
    }
}
class Solution{
    public int minMoves(String[] classroom,int energy){
        int m=classroom.length;
        int n=classroom[0].length();

        int startR=-1,startC=-1;
        int litterCount=0;
        int[][] litterId=new int[m][n];
        for(int[] row:litterId){
            Arrays.fill(row,-1);
        }

        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                char ch=classroom[r].charAt(c);
                if(ch=='S'){
                    startR=r;
                    startC=c;
                }else if(ch=='L'){
                    litterId[r][c]=litterCount++;
                }
            }
        }

        //Target mask when all litters are collected
        int targetMask=(1<<litterCount)-1;
        if(targetMask==0){
            return 0;
        }

        //visited[r][c][mask] records maximum remaining energy seen at that state
        int[][][] maxEnergy=new int[m][n][1<<litterCount];
        for(int[][] mat:maxEnergy){
            for(int[] row:mat){
                Arrays.fill(row,-1);
            }
        }

        //Queue elements: {r, c, mask, current_energy, moves}
        Queue<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{startR,startC,0,energy,0});
        maxEnergy[startR][startC][0]=energy;

        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
            int mask=curr[2];
            int e=curr[3];
            int moves=curr[4];

            if(mask==targetMask){
                return moves;
            }

            //If energy is 0, cannot move out of current cell
            if(e==0){
                continue;
            }

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<0||nr>=m||nc<0||nc>=n){
                    continue;
                }

                char cell=classroom[nr].charAt(nc);
                if(cell=='X'){
                    continue;
                }

                int nextEnergy=e-1;
                //Reset area restores full energy capacity
                if(cell=='R'){
                    nextEnergy=energy;
                }

                int nextMask=mask;
                if(cell=='L'&&litterId[nr][nc]!=-1){
                    nextMask|=(1<<litterId[nr][nc]);
                }

                //Only visit if this gives strictly better energy at this (r, c, mask)
                if(nextEnergy>maxEnergy[nr][nc][nextMask]){
                    maxEnergy[nr][nc][nextMask]=nextEnergy;
                    queue.offer(new int[]{nr,nc,nextMask,nextEnergy,moves+1});
                }
            }
        }

        return -1;
    }
}