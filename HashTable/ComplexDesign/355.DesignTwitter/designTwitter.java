class Twitter {
    Map<Integer, List<Integer>> map;
    Map<Integer, List<Integer>> followees;
    Map<Integer, Integer> indexMap;
    List<Integer> tweetsId;

    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<>();
        followees = new HashMap<>();
        tweetsId = new ArrayList<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Integer> cur = new ArrayList<>();
        if (map.containsKey(userId)) {
            cur = map.get(userId);
        }
        cur.add(0, tweetId);
        map.put(userId, cur);
        tweetsId.add(userId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        int[] indexes = new int[10];
        int len = 0;
        indexMap = new HashMap<>();
        
        for (int i = tweetsId.size() - 1; i >= 0; i--) {
            if (tweetsId.get(i) == userId || followees.get(userId) != null
                && followees.get(userId).contains(tweetsId.get(i))) {
                int index = indexMap.getOrDefault(tweetsId.get(i), 0);
                res.add(map.get(tweetsId.get(i)).get(index));
                index++;
                indexMap.put(tweetsId.get(i), index);
                len++;
            }
            if (len == 10) {
                break;
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        List<Integer> cur = new ArrayList<>();
        if (followees.containsKey(followerId)) {
            cur = followees.get(followerId);
        }
        cur.add(0, followeeId);
        followees.put(followerId, cur);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followees.containsKey(followerId)) {
            List<Integer> cur = followees.get(followerId);
            if (cur.contains(followeeId)) {
                cur.remove((Object)followeeId);
                followees.put(followerId, cur);
            }
        }
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