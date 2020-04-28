package edu.upv.poo;

public class StatisticsDisplay
        implements Observer, DisplayElement {
    
    private Subject weatherData;
    private float max = -100000.0f;
    private float min = 100000.0f;
    private float sum = 0.0f;
    private int reads = 0;
    
    public StatisticsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
        this.weatherData = weatherData;
    }
    
    public void stopNotifications() {
        weatherData.removeObserver(this);
    }
    
    @Override
    public void update(
            float temp, float humidity, float pressure) {
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
