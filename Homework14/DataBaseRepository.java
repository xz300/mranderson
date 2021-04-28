package Homework14;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private static final String DB_NAME = "weather.db";
    String insertWeather = "insert  into weather (city, localDate, weatherText, temperature) values (?, ?, ?, ?)";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherData(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\geekbrains\\SQLlite\\weather.db")) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setString(3, weather.getWeatherText());
            saveWeather.setDouble(4, weather.getTemperature());

            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    //TODO: Реализовать метод для считывания данных о погоде

    public List<Weather> getSavedWeatherData() throws SQLException {
        List<Weather> weatherList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\geekbrains\\SQLlite\\weather.db")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weather");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("id"));
                System.out.print(" ");
                System.out.print(resultSet.getString("city"));
                System.out.print(" ");
                System.out.print(resultSet.getString("localDate"));
                System.out.print(" ");
                System.out.print(resultSet.getString("weatherText"));
                System.out.print(" ");
                System.out.print(resultSet.getString("temperature"));
                System.out.println(" ");
            }
            return weatherList;
        }
    }

    public static void main(String[] args) throws SQLException {
        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        dataBaseRepository.saveWeatherData(new Weather("Moscow", "14.04.21", "Ясно", 15.3));
    }
}
