package edu.upv.poo;

import java.util.ArrayList;

public class WeatherData implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherData() {
        observers = new ArrayList<>();
    }    
    
    @Override
    public void registerObserver(Observer o) {
        if (o != null) observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (o == null) return;
        int obsIx = observers.indexOf(o);
        if (obsIx >= 0) observers.remove(obsIx);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }
    
    public void measurementsChanged() {
        notifyObservers();
    }
    
    public void setMeasurements(
            float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    
}
