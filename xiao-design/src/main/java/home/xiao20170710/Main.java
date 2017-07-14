package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/10 0010.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Context context = new Context();
        context.setCurrentState(RunState.getInstance());
        context.run();
        context.close();
        context.open();
        context.stop();
        context.open();
        context.close();
        context.run();
        context.stop();
        context.close();
        context.open();
        context.close();
    }

}
