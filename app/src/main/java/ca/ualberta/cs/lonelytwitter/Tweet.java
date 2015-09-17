package ca.ualberta.cs.lonelytwitter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jacob Charlebois on 9/16/15.
 */
public abstract class Tweet extends Object implements Tweetable{
    private String text;
    private Date date;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();

    public Tweet(String text, Date date) {
        this.setText(text);
        this.date = date;
    }

    public Tweet(String text) {
        this.setText(text);
        this.date = new Date();
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public void setText(String text){
        if(text.length() <= 140) {
            this.text = text;
        } else {
            throw new IllegalArgumentException("Tweet was too long!");
        }
    }
    public String getText(){
        return text;
    }

    public void addMood(Mood myMood) {
        moodList.add(myMood);
    }

    public abstract Boolean isImportant();
}
