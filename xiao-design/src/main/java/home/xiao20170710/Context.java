package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/13.
 * 电梯类,环境类
 */
public class Context {

    private LiftState currentState;

    // 设置当前状态
    public void setCurrentState(LiftState currentState) {
        this.currentState = currentState;
        // 将当前环境往下一直传
        currentState.setContext(this);
    }

    public void open() {
        currentState.open();
    }

    public void close() {
        currentState.close();
    }

    public void run() {
        currentState.run();
    }

    public void stop() {
        currentState.stop();
    }

}
