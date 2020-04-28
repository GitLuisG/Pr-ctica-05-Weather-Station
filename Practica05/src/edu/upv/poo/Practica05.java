package edu.upv.poo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Practica05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Practica05().run();
    }
    
    public void run() {
        
        System.out.println("== Práctica 05 ==\n");
        
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay =
                new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay =
                new ForecastDisplay(weatherData);
        
        // simulación de cambios en mediciones.
        weatherData.setMeasurements(22.3f, 65.1f, 30.4f);
        weatherData.setMeasurements(21.1f, 70.8f, 29.2f);
        weatherData.setMeasurements(20.9f, 90.3f, 29.3f);
        
        System.out.println("---------------------------");
        
        WeatherDataV2 weatherDataV2 =
                new WeatherDataV2();
        StatisticsDisplayV2 statisticsDisplayV2 =
                new StatisticsDisplayV2();
        weatherDataV2.registerListener(statisticsDisplayV2);
        ForecastDisplayV2 forecastDisplayV2 = 
                new ForecastDisplayV2();
        weatherDataV2.registerListener(
                forecastDisplayV2, "pressure");
        
        PropertyChangeListener l1 = (PropertyChangeEvent evt) -> {
            System.out.println(
                    "cambio en prop " + evt.getPropertyName());
        };
        PropertyChangeListener l2 = (evt) -> {
            System.out.println(
                    "cambio en prop " + evt.getPropertyName());
        };
        PropertyChangeListener l3 = (evt) ->
                System.out.println("cambio Prop " + evt.getPropertyName());
        
        weatherDataV2.registerListener(l1);
        weatherDataV2.registerListener(l2);
        weatherDataV2.registerListener(l3);
        weatherDataV2.registerListener(
                (e) -> System.out.println(e.getPropertyName()));
        weatherDataV2.registerListener(this::cambioPropiedad);
        
        // simulación de cambios de mediciones.
        weatherDataV2.setTemperature(22.3f);
        weatherDataV2.setTemperature(21.1f);
        weatherDataV2.setTemperature(20.9f);
        weatherDataV2.setPressure(30.4f);
        weatherDataV2.setPressure(29.2f);
        weatherDataV2.setPressure(29.3f);
        
        MiInterfaceFuncional op1 = (v1, v2) -> v1 + v2;
        execCalc(2.43, 4.12, op1);
        
        System.out.println(
                "1.2 + 3.1 = " + op1.hacerOperacion(1.2, 3.1));
        
    }
    
    private void cambioPropiedad(PropertyChangeEvent evt) {
        System.out.println(
                "Cambio de propiedad " + evt.getPropertyName() +
                " al valor " + evt.getNewValue());
    }
    
    private void execCalc(
            double v1, double v2, MiInterfaceFuncional op) {
        double resultado = op.hacerOperacion(v1, v2);
        System.out.println("El resultado es " + resultado);
    }
    
}
