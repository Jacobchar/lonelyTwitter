package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Jacob Charlebois on 9/16/15.
 */
public class Happy extends Mood {

    private String text;

    public Happy(Date date) {
        super(date);
    }

    public Happy() {
    }

    public String moodRepresentation(){
        return "I am happy";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
