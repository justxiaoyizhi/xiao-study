package home.xiao20170627;

/**
 * Created by Xiao on 2017/6/27.
 */
public class Client {

    public static void main(String[] args) {
        AddUserReceiver receiver = new AddUserReceiver();
        Command command = new AddUserCommand(receiver);
        /*GetUserReceiver receiver = new GetUserReceiver();
        Command command = new GetUserCommand(receiver);*/

        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.executeCommand();
    }
}
