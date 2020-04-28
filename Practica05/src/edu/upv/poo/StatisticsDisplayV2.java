package edu.upv.poo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StatisticsDisplayV2 
        implements PropertyChangeListener, DisplayElement {
    
    private float max = -10000.0f;
    private float min = 10000.0f;
    private float sum = 0.0f;
    private int reads = 0;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        if (!evt.getPropertyName().equals("temperature"))
            return;
        
        float oldTemp = (Float)evt.getOldValue();
        float temp = (Float)evt.getNewValue();
        
        WeatherDataV2 weatherData = null;
        if (evt.getSource() instanceof WeatherDataV2)
            weatherData = (WeatherDataV2)evt.getSource();
        
        if (temp > max) max = temp;
        if (temp < min) min = temp;
        sum += temp;
        reads++;
        
        display();
        
    }

    @Override
    public void display() {
        if (reads == 0) {
            System.out.println("[NO DATA]");
            return;
        }
        System.out.printf(
                "Avg / Min / Max temp = %.02f / %.02f / %.02f\n",
                sum / reads, min, max);
    }
    
}
