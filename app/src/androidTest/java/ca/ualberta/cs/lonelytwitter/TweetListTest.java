package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by charlebo on 9/30/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testRemoveTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihii");
        tweetList.addTweet(tweet);
        tweetList.removeTweet(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihii");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testAddTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihii");
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
        boolean caughtException = false;
        try{
            tweetList.addTweet(tweet);
        } catch(IllegalArgumentException e) {
            caughtException = true;
        }
        assertTrue(caughtException);
    }

    public void testGetTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihii");
        tweetList.addTweet(tweet);
        Tweet returnedTweet = tweetList.getTweet(0);
        assertTrue((tweet.date.equals(returnedTweet.date)) &&
                (tweet.getText().equals(returnedTweet.getText())));
    }

    public void testTweetCount() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihii");
        tweetList.addTweet(tweet);
        Tweet tweet1 = new NormalTweet("byebyebye");
        tweetList.addTweet(tweet1);
        int tweets = tweetList.getCount();
        assertEquals(2, tweets);
    }

    public void testGetTweets(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihii");
        tweetList.addTweet(tweet);
        Tweet tweet1 = new NormalTweet("hellOoOo");
        tweetList.addTweet(tweet1);
        Tweet tweet2 = new NormalTweet("byebyebye");
        tweetList.addTweet(tweet2);
        ArrayList<Tweet> returnedTweets = tweetList.getTweets();
        assertTrue((tweet.equals(returnedTweets.get(0))&&
                tweet1.equals(returnedTweets.get(1))&&tweet2.equals(returnedTweets.get(2))));
    }

}