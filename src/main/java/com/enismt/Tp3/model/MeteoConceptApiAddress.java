package com.enismt.Tp3.model;

import java.util.List;

public class MeteoConceptApiAddress {
    public List<Forecast> forecast;

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

}
