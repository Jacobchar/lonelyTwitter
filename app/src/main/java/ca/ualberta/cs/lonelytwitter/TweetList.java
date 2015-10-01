package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by charlebo on 9/30/15.
 */
public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private int count;

    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

    public void addTweet(Tweet tweet) {
        if(tweets.contains(tweet)){
            throw new IllegalArgumentException("This tweet has already been added!");
        }
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public void tweetCount(ArrayList<Tweet> tweets) {
        for(Tweet tweet:tweets){
            count ++;
        }
    }

    public int getCount(){
        tweetCount(tweets);
        return count;
    }

    public ArrayList<Tweet> getTweets(){
        ArrayList<Tweet> chronolist = tweets;
        return chronolist;
    }
}
