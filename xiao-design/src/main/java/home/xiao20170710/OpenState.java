package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/10 0010.
 */
public class OpenState extends LiftState {

    public void open() {
        System.out.println("电梯门打开");
    }

    // 状态切换
    public void close() {
        super.getContext().setCurrentState(CloseState.getInstance());
        super.getContext().close();
    }

    public void run() {
        // TODO:什么也不做
    }

    public void stop() {
        // TODO:什么也不做
    }

    private OpenState() {

    }

    public static OpenState getInstance() {
        return OpenStateStatic.openState;
    }

    private static class OpenStateStatic {
        private static OpenState openState = new OpenState();
    }
}
