package home.xiao20170627;

/**
 * Created by Xiao on 2017/6/27.
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
