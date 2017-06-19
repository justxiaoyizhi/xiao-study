package home.xiao20170619;

/**
 * Created by Xiao on 2017/6/19.
 */
public class SecondReceiver implements Observer {

    private Subject subject;

    public SecondReceiver(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void receiveUpdate() {
        System.out.println("second receive data");
    }
}
