package home.xiao20170619;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiao on 2017/6/19.
 */
public class WeatherData implements Subject {

    private List<Observer> observers;
    private String data;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(observers.indexOf(o) >= 0) {
            observers.remove(o);
        }
    }

    @Override
    public void noticeObservers() {
        for (Observer observer : observers) {
            observer.receiveUpdate();
        }
    }

    public void setData(String data) {
        this.data = data;
        noticeObservers();
    }
}
