package home.xiao20170627;

/**
 * Created by Xiao on 2017/6/27.
 */
public class GetUserCommand implements Command {

    private GetUserReceiver receiver;

    public GetUserCommand(GetUserReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.get();
    }
}
