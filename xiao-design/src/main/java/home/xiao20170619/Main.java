package home.xiao20170619;

/**
 * Created by Xiao on 2017/6/19.
 */
public class Main {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        new FirstReceiver(weatherData);
        new SecondReceiver(weatherData);
        weatherData.setData("123");
    }
}
