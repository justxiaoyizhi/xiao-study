package home.xiao20170619;

/**
 * Created by Xiao on 2017/6/19.
 */
public class FirstReceiver implements Observer {

    private Subject subject;

    public FirstReceiver(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void receiveUpdate() {
        System.out.println("first receive data");
    }
}
