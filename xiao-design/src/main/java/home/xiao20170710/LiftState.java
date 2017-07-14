package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/10 0010.
 */
public abstract class LiftState {

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();

}
