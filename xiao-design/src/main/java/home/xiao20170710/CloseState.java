package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/10 0010.
 */
public class CloseState extends LiftState {

    public void open() {
        super.getContext().setCurrentState(OpenState.getInstance());
        super.getContext().open();
    }

    public void close() {
        System.out.println("电梯门关闭");
    }

    public void run() {
        super.getContext().setCurrentState(RunState.getInstance());
        super.getContext().run();
    }

    public void stop() {

    }

    private CloseState() {

    }

    public static CloseState getInstance() {
        return OpenStateStatic.openState;
    }

    private static class OpenStateStatic {
        private static CloseState openState = new CloseState();
    }
}
