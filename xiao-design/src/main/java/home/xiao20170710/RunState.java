package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/10 0010.
 */
public class RunState extends LiftState {

    public void open() {
    }

    public void close() {
    }

    public void run() {
        System.out.println("电梯运行中");
    }

    public void stop() {
        super.getContext().setCurrentState(StopState.getInstance());
        super.getContext().stop();
    }

    private RunState() {

    }

    public static RunState getInstance() {
        return OpenStateStatic.openState;
    }

    private static class OpenStateStatic {
        private static RunState openState = new RunState();
    }
}
