package home.xiao20170619;

/**
 * Created by Xiao on 2017/6/19.
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void noticeObservers();
}
