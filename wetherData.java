/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication93;

/**
 *
 * @author walidzein
 */
import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.Objects;

//{
// "coord":{"lon":-122.09,"lat":37.39},
// "weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],
// "base":"stations",
// "main":{"temp":280.44,"pressure":1017,"humidity":61,"temp_min":279.15,"temp_max":281.15},
// "visibility":12874,
// "wind":{"speed":8.2,"deg":340,"gust":11.3},
// "clouds":{"all":1},
// "dt":1519061700,
// "sys":{"type":1,"id":392,"message":0.0027,"country":"US","sunrise":1519051894,"sunset":1519091585},
// "id":0,
// "name":"Mountain View",
// "cod":200}
public class wetherData {


    public Map<String, Float> getWeather() {
        return weather;
    }

    public void setWeather(Map<String, Float> weather) {
        this.weather = weather;
    }

    public Map<String, Float> getMainData() {
        return mainData;
    }

    public void setMainData(Map<String, Float> mainData) {
        this.mainData = mainData;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "mainData=" + mainData +
                ", weather=" + weather +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof wetherData)) return false;
        wetherData that = (wetherData) o;
        return Objects.equals(getMainData(), that.getMainData()) &&
                Objects.equals(getWeather(), that.getWeather());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMainData(), getWeather());
    }

    @SerializedName("main")
    Map<String, Float> mainData;
    Map<String, Float> weather;
}
