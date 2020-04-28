package edu.upv.poo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ForecastDisplayV2
        implements PropertyChangeListener, DisplayElement {
    
    private float currentPressure;
    private float lastPressure;
    private int reads;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {        
        reads++;
        lastPressure = currentPressure;
        currentPressure = (Float)evt.getNewValue();
        display();
    }

    @Override
    public void display() {
        if (reads < 2) {
            System.out.println("[NO FORECAST]");
            return;
        }
        if (currentPressure > lastPressure)
            System.out.println("Forecast: Improving weather on the way!");
        else if (currentPressure < lastPressure)
            System.out.println("Forecast: Watch out for cooler, rainy weather.");
        else
            System.out.println("Forecast: More of the same.");
    }
    
}
