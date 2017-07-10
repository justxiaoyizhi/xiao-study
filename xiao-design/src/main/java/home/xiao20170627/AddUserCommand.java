package home.xiao20170627;

/**
 * Created by Xiao on 2017/6/27.
 */
public class AddUserCommand implements Command {

    private AddUserReceiver receiver;

    public AddUserCommand(AddUserReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.add();
    }
}
