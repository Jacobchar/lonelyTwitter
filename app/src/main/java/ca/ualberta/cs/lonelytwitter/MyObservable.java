package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by charlebo on 10/7/15.
 */
public interface MyObservable {

    void notifyObservers();
    void addObserver(MyObserver o);


}