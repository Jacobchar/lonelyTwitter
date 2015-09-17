package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Jacob Charlebois on 9/16/15.
 */
public class Sad extends Mood {

    private String text;

    public Sad(Date date) {
        super(date);
    }

    public Sad() {
    }

    public String moodRepresentation(){
        return "I am sad";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
