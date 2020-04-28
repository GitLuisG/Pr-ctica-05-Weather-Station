package edu.upv.poo;

public class CurrentConditionsDisplay
        implements Observer, DisplayElement {
    
    private float temperature;
    private float humidity;
    private Subject weatherData;
    
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(
            float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
    
    @Override
    public void display() {
        System.out.printf(
                "Curren conditions: %.2f C degrees and" +
                " %.2f %% humidity\n",
                temperature, humidity);
    }
    
}
