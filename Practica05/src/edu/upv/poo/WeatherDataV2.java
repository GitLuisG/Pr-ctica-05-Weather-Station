package edu.upv.poo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WeatherDataV2
        implements NewSubject {
    
    private PropertyChangeSupport pcs =
            new PropertyChangeSupport(this);
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void registerListener(PropertyChangeListener l) {
        System.out.println(
                "Registrando objeto de tipo " +
                l.getClass().getSimpleName());
        pcs.addPropertyChangeListener(l);
    }

    @Override
    public void removeListener(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

    @Override
    public void registerListener(
            PropertyChangeListener l, String propertyName) {
        pcs.addPropertyChangeListener(propertyName, l);
    }

    @Override
    public void removeListener(
            PropertyChangeListener l, String propertyName) {
        pcs.removePropertyChangeListener(propertyName, l);
    }
    
    /**
     * @return the temperature
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(float temperature) {
        float old = this.temperature;
        this.temperature = temperature;
        pcs.firePropertyChange("temperature", old, temperature);
    }

    /**
     * @return the humidity
     */
    public float getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(float humidity) {
        float old = this.humidity;
        this.humidity = humidity;
        pcs.firePropertyChange("humidity", old, humidity);
    }

    /**
     * @return the pressure
     */
    public float getPressure() {
        return pressure;
    }

    /**
     * @param pressure the pressure to set
     */
    public void setPressure(float pressure) {
        float old = this.pressure;
        this.pressure = pressure;
        pcs.firePropertyChange("pressure", old, pressure);
    }

}
