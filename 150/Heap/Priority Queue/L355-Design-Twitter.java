
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {
    int count;
    Map<Integer,List<int[]>>tweetMap;
    Map<Integer,Set<Integer>>followMap;
    public Twitter() {
        count=0;
        tweetMap=new HashMap<>();
        followMap=new HashMap<>();
    }
    public void postTweet(int userId,int tweetId) {
        tweetMap.computeIfAbsent(userId,k->new ArrayList<>()).add(new int[]{count,tweetId});
        count++;
    }
    public List<Integer> getNewsFeed(int userId) {
        List<Integer>res=new ArrayList<>();
        PriorityQueue<int[]>maxHeap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        followMap.computeIfAbsent(userId,k->new HashSet<>()).add(userId);
        for(int followeeId:followMap.get(userId)){
            if(tweetMap.containsKey(followeeId)){
                int index=tweetMap.get(followeeId).size()-1;
                int[]tweet=tweetMap.get(followeeId).get(index);
                maxHeap.offer(new int[]{tweet[0],tweet[1],followeeId,index-1});
            }
        }
        while(!maxHeap.isEmpty()&&res.size()<10){
            int[]curr=maxHeap.poll();
            int count=curr[0];
            int tweetId=curr[1];
            int followeeId=curr[2];
            int index=curr[3];

            res.add(tweetId);

            if(index>=0){
                int[]tweet=tweetMap.get(followeeId).get(index);
                maxHeap.offer(new int[]{tweet[0],tweet[1],followeeId,index-1});
            }
        }
        return res;
    }
    public void follow(int followerId,int followeeId) {
        followMap.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }
    public void unfollow(int followerId,int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
    public static void main(String[] args) {
        Twitter twitter=new Twitter();
        twitter.postTweet(1,5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1,2);
        System.out.println(twitter.getNewsFeed(1));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */