package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/13.
 */
public class StopState extends LiftState {

    public void open() {
        super.getContext().setCurrentState(OpenState.getInstance());
        super.getContext().open();
    }

    public void close() {
    }

    public void run() {
    }

    public void stop() {
        System.out.println("电梯停止了");
    }

    private StopState() {

    }

    public static StopState getInstance() {
        return StopStateStatic.stopState;
    }

    private static class StopStateStatic {
        private static StopState stopState = new StopState();
    }
}
