package com.learn.ds;

import java.util.*;

public class Twitter {
    Map<Integer, TwitterUser> users = new HashMap<>();

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        TwitterUser user = getUser(userId);
        user.addTweet(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        TwitterUser user = getUser(userId);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int tweet : user.tweets) {
            minHeap.offer(tweet);
        }

        for (int each : user.followees) {
            TwitterUser followee = getUser(each);
            for (int tweet : followee.tweets) {
                minHeap.offer(tweet);
            }
        }

        while(minHeap.size() > 10) {
            minHeap.poll();
        }

        List<Integer> feeds = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            feeds.add(0, minHeap.poll());
        }

        return feeds;
    }

    public void follow(int followerId, int followeeId) {
        TwitterUser follower = getUser(followerId);
        TwitterUser followee = getUser(followeeId);
        follower.addFollowee(followeeId);
        followee.addFollower(followerId);
    }

    public void unfollow(int followerId, int followeeId) {
        TwitterUser follower = getUser(followerId);
        TwitterUser followee = getUser(followeeId);
        follower.removeFollowee(followeeId);
        followee.removeFollower(followerId);
    }

    private TwitterUser getUser(int user) {
        if (!users.containsKey(user)) {
            users.put(user, new TwitterUser());
        }
        return users.get(user);
    }

    public static void main(String[] args) {
        //["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet",
        // "postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet",
        // "postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet",
        // "postTweet","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
        // [[],[1,5],[2,3],[1,101],[2,13],[2,10],[1,2],[1,94],[2,505],[1,333],[2,22],[1,11],[1,205],
        // [2,203],[1,201],[2,213],[1,200],[2,202],[1,204],[2,208],[2,233],[1,222],[2,211],[1],[1,2],
        // [1],[1,2],[1]]
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(2, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(2, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(2, 22);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 205);
        twitter.postTweet(1, 203);
        twitter.postTweet(1, 201);
        twitter.postTweet(2, 213);
        twitter.postTweet(1, 200);
        twitter.postTweet(2, 202);
        twitter.postTweet(1, 204);
        twitter.postTweet(2, 208);
        twitter.postTweet(2, 233);
        twitter.postTweet(1, 222);
        twitter.postTweet(2, 211);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));




        /*System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));*/
    }
}

class TwitterUser {
    Queue<Integer> tweets = new LinkedList<>();
    Set<Integer> followers = new HashSet<>();
    Set<Integer> followees = new HashSet<>();

    void addTweet(int tweetId) {
        tweets.offer(tweetId);
    }

    void removeFollowee (int followeeId) {
        followees.remove(followeeId);
    }

    void addFollowee (int followeeId) {
        followees.add(followeeId);
    }

    void removeFollower (int follower) {
        followers.remove(follower);
    }

    void addFollower (int follower) {
        followers.add(follower);
    }
}
