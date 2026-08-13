class Twitter {
    Map<Integer, Set<Integer>> following;
    Map<Integer, List<Tweet>> tweets;
    int time;

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        // Create tweet list if user doesn't exist
        tweets.putIfAbsent(userId, new ArrayList<>());

        // Add tweet with current timestamp
        tweets.get(userId).add(new Tweet(tweetId, time++));

        // Create following set if user doesn't exist
        following.putIfAbsent(userId, new HashSet<>());
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        // Max heap: newest tweet comes first
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }

        // Add tweets of people user follows
        Set<Integer> followees =
            following.getOrDefault(userId, new HashSet<>());

        for (int followee : followees) {
            if (tweets.containsKey(followee)) {
                pq.addAll(tweets.get(followee));
            }
        }

        // Get 10 most recent tweets
        while (!pq.isEmpty() && result.size() < 10) {
            result.add(pq.poll().tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        following.putIfAbsent(followerId, new HashSet<>());

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}