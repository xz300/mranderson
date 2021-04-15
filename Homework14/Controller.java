package Homework14;

import java.io.IOException;

public class Controller {
    WeatherModel weatherModel = new AccuWeatherModel();

    // 1 - узнать текущую погоду    2 - узнать прогноз на 5 дней
    public void getWeather(String command, String selectedCity) throws IOException {
        switch (Functionality.fromValue(command)) {
            case GET_CURRENT_WEATHER:
                weatherModel.getWeather(Period.NOW, selectedCity);
                break;
            case GET_WEATHER_IN_NEXT_FIVE_DAYS:
                //your code here
                throw new IOException("Метод не реализован!");
                //TODO: Добавить 3 опцию из Functionality(enum)
            case GET_SAVED_WEATHER_DATA:
                weatherModel.getSavedWeatherData();
                break;
        }
    }
}
