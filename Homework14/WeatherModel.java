package Homework14;

import java.io.IOException;

public interface WeatherModel {
    void getWeather(Period period, String selectedCity) throws IOException;

    void getSavedWeatherData();
}
