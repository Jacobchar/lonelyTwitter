package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Jacob Charlebois on 9/16/15.
 */
public class ImportantTweet extends Tweet {

    public ImportantTweet(String tweet, Date date) {
        super(tweet, date);
    }

    public ImportantTweet(String tweet) {
        super(tweet);
    }

    public Boolean isImportant(){
        return Boolean.TRUE;
    }

    @Override
    public String getText() {
        return "!!! " + super.getText() + " !!!" ;
    }
}
