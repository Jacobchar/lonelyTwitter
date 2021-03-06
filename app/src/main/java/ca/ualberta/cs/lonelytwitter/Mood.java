package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Jacob Charlebois on 9/16/15.
 */
public abstract class Mood {

    private Date date;

    public Mood(Date date) {
        this.setDate(date);
    }

    public Mood(){
        this.setDate(new Date());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String moodRepresentation();
}
