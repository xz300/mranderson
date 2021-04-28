package Homework14;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;

public class AccuWeatherModel implements WeatherModel {
    private static final String PROTOKOL = "http";
    private static final String API_KEY = "zXFQx6HRSS5waPW5VOJIsLIkJA7BEANt";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_V1 = "v1";
    private static final String LOCATIONS_ENDPOINT = "locations";
    private static final String CITIES_ENDPOINT = "cities";
    private static final String AUTOCOMPLETE_ENDPOINT = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(Period period, String selectedCity) throws IOException, SQLException {
        String cityKey = detectCityKey(selectedCity);
        String city =getCityKey(selectedCity);
        String data;
        double tempetature;
        String weather;
        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        if (period == Period.NOW) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOKOL)
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_V1)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(httpUrl)
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            String responseString = response.body().string();
            //TODO: вызвать метод сохранения погоды в базу из DataBaseRepository, предварительно из responseString
            //достав нужные данные для создания объекта Weather
            System.out.println(responseString);
            System.out.println("Город: " + city);
            data = objectMapper.readTree(responseString).get(0).at("/LocalObservationDateTime").asText();
            System.out.println("Дата: " + data);
            tempetature = Double.parseDouble(objectMapper.readTree(responseString).get(0).at("/Temperature/Metric/Value").asText());
            System.out.println("Температура : " + tempetature);
            weather = objectMapper.readTree(responseString).get(0).at("/WeatherText").asText();
            System.out.println("На небе: " + weather);
            String temp2 = objectMapper.readTree(responseString).get(0).at("/HasPrecipitation").asText();
            System.out.println("Осадки: " + temp2);
//                public Weather(String city, String localDate, String weatherText, double temperature) {
                Weather weatherDB = new Weather(city, data, weather, tempetature);
            dataBaseRepository.saveWeatherData(weatherDB);
        }

        if (period == Period.FIVE_DAYS) {
            //TODO: Домашнее задание со звездочкой
        }
    }

    @Override
    public void getSavedWeatherData() {
        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        try {
            dataBaseRepository.getSavedWeatherData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //TODO: Обратиться к  DataBaseRepository и вызвать метод getSavedWeatherData
    }

    public String detectCityKey(String selectedCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS_ENDPOINT)
                .addPathSegment(API_V1)
                .addPathSegment(CITIES_ENDPOINT)
                .addPathSegment(AUTOCOMPLETE_ENDPOINT)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();


        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();

//        System.out.println("Город: " + cityKey);
        return cityKey;

    }
    public String getCityKey(String selectedCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS_ENDPOINT)
                .addPathSegment(API_V1)
                .addPathSegment(CITIES_ENDPOINT)
                .addPathSegment(AUTOCOMPLETE_ENDPOINT)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String city = objectMapper.readTree(responseString).get(0).at("/LocalizedName").asText();


//        System.out.println("Город: " + cityKey);
        return city;

    }
}
