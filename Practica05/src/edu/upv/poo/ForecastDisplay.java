package edu.upv.poo;

public class ForecastDisplay 
        implements Observer, DisplayElement {
    
    private Subject weatherData;
    private float currentPressure;
    private float lastPressure;
    private int reads;
    
    public ForecastDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
        this.weatherData = weatherData;
    }
    
    public void disableNotifications() {
        weatherData.removeObserver(this);
    }
    
    public void enableNotifications() {
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(
            float temp, float humidity, float pressure) {
        reads++;
        lastPressure = currentPressure;
        currentPressure = pressure;
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
