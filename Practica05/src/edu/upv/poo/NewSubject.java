package edu.upv.poo;

import java.beans.PropertyChangeListener;

public interface NewSubject {    
    void registerListener(PropertyChangeListener l);
    void registerListener(
            PropertyChangeListener l, String propertyName);
    void removeListener(PropertyChangeListener l);  
    void removeListener(
            PropertyChangeListener l, String propertyName);
}
